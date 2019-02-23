package com.IMBA.service;

import com.IMBA.entity.course;
import com.IMBA.entity.student;

import java.util.List;
import java.util.Map;

public interface courseService {

    //通过课程id查找课程
    public course findCourseById(int courseId);

    //添加课程
    public int addCourse(course course);


}
