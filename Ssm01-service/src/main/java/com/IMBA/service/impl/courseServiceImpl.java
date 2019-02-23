package com.IMBA.service.impl;

import com.IMBA.dao.courseMapper;
import com.IMBA.entity.course;
import com.IMBA.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("courseService")
public class courseServiceImpl implements courseService {
    @Autowired
    courseMapper coursemapper;
    public course findCourseById(int courseId) {
        course c=coursemapper.selectByPrimaryKey(courseId);
        return c;
    }

    public int addCourse(course course) {
        try{
            int n=coursemapper.insertSelective(course);
             return n;
        }catch (Exception e){
            return -1;
        }

    }
}
