package com.IMBA.service.impl;

import com.IMBA.dao.courseMapper;
import com.IMBA.entity.course;
import com.IMBA.entity.examination;
import com.IMBA.entity.major;
import com.IMBA.service.courseService;
import com.IMBA.service.majorService;
import com.IMBA.service.stu_courseService;
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
    @Autowired
    stu_courseService stuCourseService;
    @Autowired
    majorService majorservice;

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

    //TODO
    public boolean addToCourseFromExam(examination exam){
        return false;
    }
}
