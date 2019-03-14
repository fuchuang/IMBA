package com.IMBA.service.impl;

import com.IMBA.dao.courseInfoMapper;
import com.IMBA.dao.courseMapper;
import com.IMBA.dto.examResultDto;
import com.IMBA.entity.course;
import com.IMBA.entity.course_info;
import com.IMBA.entity.examination;
import com.IMBA.entity.major;
import com.IMBA.service.courseService;
import com.IMBA.service.majorService;
import com.IMBA.service.stu_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("courseService")
public class courseServiceImpl implements courseService {
    @Autowired
    courseMapper coursemapper;
    @Autowired
    stu_courseService stuCourseService;
    @Autowired
    majorService majorservice;
    @Autowired
    courseInfoMapper course_info_Mapper;

    //得到课程的详细信息
    public course findCourseById(int courseId) {
        //返回的数据包括 课程名称 上课地点 上课时间 上课老师 上此课的班级
        course result=coursemapper.selectByCouseId(courseId);
        List<Integer> majors=stuCourseService.findMajorByCourseId(courseId);
        for (int i=0;i<majors.size();i++){
            major record= majorservice.findById(majors.get(i));
            if (record!=null){
                result.addMajor(record);
            }
        }
        return result;
    }

    public int addCourse(course course) {
        try{
            int n=coursemapper.insertSelective(course);
             return n;
        }catch (Exception e){
            return -1;
        }

    }
    @Transactional(propagation= Propagation.REQUIRED)
    public int examToCourse(examResultDto exam,int stuId) {
        //添加course_info
        course_info courseInfo=new course_info();
        courseInfo.setCourse_name(exam.getCourseName()+"考试");
        courseInfo.setClassroom(exam.getSite());
        courseInfo.setCourseYear(getSchoolYear());
        course_info_Mapper.insertSelective(courseInfo);
        int courseInfoId=courseInfo.getId();
        //添加实体course
        course c=new course();
        c.setCourseInfoId(courseInfoId);
        c.setWeekOfSemester(exam.getWeekOfSemester());
        c.setDayOfWeek(exam.getDayOfWeek());
        c.setCourseTime(exam.getExamTime());
        coursemapper.insertSelective(c);
        int course_exam_id =c.getId();
        //增加 学生-课程
        int stu_course_id=stuCourseService.addStuCourse(stuId,course_exam_id);
        return stu_course_id;

    }

    public void deleteExamToCourse(int stuCourseId) {
        int courseId=stuCourseService.findCourseIdById(stuCourseId);
        stuCourseService.deleteCourse(stuCourseId);
        course c=coursemapper.selectExamCourseByCouseId(courseId);
        coursemapper.deleteByPrimaryKey(courseId);
        int course_info_id=c.getCourseInfoId();
        course_info_Mapper.deleteById(course_info_id);
    }

    private String getSchoolYear(){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        String schoolYear;
        if (3<month && month<9){
            schoolYear=year+"年上半学期";
        }else {
            schoolYear=year+"年下半学期";
        }
        return schoolYear;
    }

}
