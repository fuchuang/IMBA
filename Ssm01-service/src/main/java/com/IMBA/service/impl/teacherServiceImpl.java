package com.IMBA.service.impl;

import com.IMBA.dao.stu_teacher_likesMapper;
import com.IMBA.dao.teacherMapper;
import com.IMBA.dto.stuCourseDto;
import com.IMBA.dto.teachInfoDto;
import com.IMBA.entity.stu_teacher_likes;
import com.IMBA.entity.teacher;
import com.IMBA.service.stu_courseService;
import com.IMBA.service.teacherService;
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

    public List<teachInfoDto> getTeachersInfo(int stuId) {
        //还要返回学生是否已点赞老师 一个老师任教的课程可能有多门
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
}
