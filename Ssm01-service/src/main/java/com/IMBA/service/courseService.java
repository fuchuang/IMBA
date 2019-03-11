package com.IMBA.service;

import com.IMBA.dto.examResultDto;
import com.IMBA.entity.course;
import com.IMBA.entity.student;

import java.util.List;
import java.util.Map;

public interface courseService {

    //通过课程id查找课程
     course findCourseById(int courseId);

    //添加课程
     int addCourse(course course);

    //把考试包装成课程
    boolean examToCourse(examResultDto exam);




}
