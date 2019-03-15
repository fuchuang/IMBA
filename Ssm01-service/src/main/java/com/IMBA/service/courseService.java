package com.IMBA.service;

import com.IMBA.dto.examResultDto;
import com.IMBA.entity.course;
import com.IMBA.model.coursemodel;

import java.util.List;

public interface courseService {
    //通过课程id查找课程
    course findCourseById(int courseId);

    //添加课程
    int addCourse(course course);

    //把考试包装成课程
    int examToCourse(examResultDto exam, int stuId);

    //删除标记到课表所创建的course和course_info
    public void deleteExamToCourse(int stuCourseId);

}
