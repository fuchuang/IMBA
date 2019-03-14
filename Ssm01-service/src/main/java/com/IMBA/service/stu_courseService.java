package com.IMBA.service;

import java.util.List;

import com.IMBA.dto.stuCourseDto;
import com.IMBA.entity.course;
import org.apache.ibatis.annotations.Param;

public interface stu_courseService {
    //查找该学生具体一周的课程
    List<course> findCoursesOfWeek( Integer stuId,String year,Byte week);

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
