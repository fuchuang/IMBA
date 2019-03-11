package com.IMBA.service.impl;

import com.IMBA.dao.stu_teacher_likesMapper;
import com.IMBA.dao.teacherMapper;
import com.IMBA.dto.stuCourseDto;
import com.IMBA.dto.teachInfoDto;
import com.IMBA.entity.stu_teacher_likes;
import com.IMBA.entity.teacher;
import com.IMBA.entity.teaching_evaluation;
import com.IMBA.service.stu_courseService;
import com.IMBA.service.teacherService;
import com.IMBA.service.teaching_evaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("teacherService")
public class teacherServiceImpl implements teacherService {
    @Autowired
    teacherMapper mapper;
    @Autowired
    stu_courseService stuCourseService;
    @Autowired
    stu_teacher_likesMapper teacherLikesMapper;
    @Autowired
    teaching_evaluationService teachingEvaluationService;

    public List<teachInfoDto> getTeachersInfo(int stuId) {
        List<teachInfoDto> result=new ArrayList<teachInfoDto>();
        List<stuCourseDto> courses =stuCourseService.findCoursesList(stuId);
        for (int i=0;i<courses.size();i++){
            int id=courses.get(i).getCourseId();
            teacher t=mapper.selectByCourseId(id);
            if (t!=null){
                teachInfoDto isExist=isExist(t.getId(),result);
                if (isExist!=null){
                    isExist.getCoursesName().add(courses.get(i).getCourseName());
                }else {
                    teachInfoDto td=new teachInfoDto();
                    td.setTeacher(t,courses.get(i).getCourseName());
                    Integer n=mapper.selectIsLike(stuId,td.getId());
                    if (n!=null){
                        td.setLike(true);
                    }else {
                        td.setLike(false);
                    }

                    if (isEvaluated(stuId,td.getId())){
                        td.setEvaluate(true);
                    }else {
                        td.setEvaluate(false);
                    }
                    result.add(td);
                }

            }
        }
        return result;
    }

    public boolean addLikes(int stuId, int teacherId) {
        stu_teacher_likes like=new stu_teacher_likes();
        like.setStudentId(stuId);
        like.setTeacherId(teacherId);
        int n=teacherLikesMapper.insert(like);
        if (n!=0){
            return true;
        }
        return false;
    }

    public boolean cancelLikes(int stuId, int teacherId) {
        stu_teacher_likes like=new stu_teacher_likes();
        like.setTeacherId(teacherId);
        like.setStudentId(stuId);
        int n=teacherLikesMapper.deleteByPrimaryKey(like);
        if (n!=0){
            return true;
        }
        return false;
    }

    public boolean evaluteTeacher(int stuId, int teacherId, float grade) {
        //添加学生-评价 2.更新教师评分
        boolean addSuccess =teachingEvaluationService.addEvaluation(stuId,teacherId,grade);
        if (addSuccess){
            updateEvaluateGrade(teacherId,grade);
            return true;
        }
        return false;
    }

    public float getEvaluateById(int teacherId) {
        teacher t=mapper.selectByPrimaryKey(teacherId);
        return t.getGrade();
    }

    //检查列表中的教师列表是否已存在
    private teachInfoDto isExist(int teacherId,List<teachInfoDto> list){
        for (int i=0;i<list.size();i++){
            teachInfoDto record=list.get(i);
            if (record.getId()==teacherId){
                return record;
            }
        }
        return null;
    }

    //更新教师评分
    private boolean updateEvaluateGrade(int teacherId,float grade){

        teacher t=mapper.selectByPrimaryKey(teacherId);
        System.out.println(t.getGrade());
        float newGrade=(t.getGrade()+grade)/(t.getEvaluateNum()+1);
        t.setEvaluateNum(t.getEvaluateNum()+1);
        t.setGrade(newGrade);
        int n=mapper.updateGradeByTeacherId(t);
        if (n==1)return true;
        return false;
    }

    private boolean isEvaluated(int studentId,int teacherId){
        if (teachingEvaluationService.findBystuIdAndTeacherId(studentId,teacherId))return true;
        return false;
    }
}
