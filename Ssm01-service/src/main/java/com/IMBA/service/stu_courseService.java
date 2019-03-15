package com.IMBA.service;

import com.IMBA.dto.stuCourseDto;
import com.IMBA.entity.course;
import com.IMBA.model.studentregistermodel;

import java.util.List;

public interface stu_courseService {
    int findcount(int courseid);
    List<studentregistermodel>findstudentregistermodel(int courseinfoid,int day_of_week,int week_of_semester,int lesson_of_day);


    //查找该学生具体一周的课程
    List<course> findCoursesOfWeek(Integer stuId, String year, Byte week);

    //查找该学生具体一天的课程
    List<course> findCoursesOfDay(Integer stuId,String year,Byte week,Byte day);

    //添加该学生的具体课程
    int addStuCourse(int StuId,int courseId);

    //查询该学生所上过的课程目录
    List<stuCourseDto> findCoursesList(int stuId);

    //根据课程id球同上一门课程的专业id
    List<Integer> findMajorByCourseId(int courseId);

    //查询整个学期的课程
    List<course> findCourseOfSemester(int stuId,String year);

    //删除课程
    boolean deleteCourse(int stuCourseId);

    int findCourseIdById(int id);
}
