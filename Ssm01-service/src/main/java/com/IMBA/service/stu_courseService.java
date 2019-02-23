package com.IMBA.service;

import java.util.List;
import com.IMBA.entity.course;
import org.apache.ibatis.annotations.Param;

public interface stu_courseService {
    //查找该学生具体一周的课程
    List<course> findCoursesOfWeek( Integer stuId,String year,Byte week);

    //查找该学生具体一天的课程
    List<course> findCoursesOdDay(Integer stuId,String year,Byte week,Byte day);

    //添加该学生的具体课程
    boolean addStuCourse(int StuId,int courseId);


}
