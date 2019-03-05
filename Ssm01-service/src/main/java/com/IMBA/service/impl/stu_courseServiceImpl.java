package com.IMBA.service.impl;

import com.IMBA.dao.stu_courseMapper;
import com.IMBA.model.studentregistermodel;
import com.IMBA.service.stu_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stu_courseService")
public class stu_courseServiceImpl implements stu_courseService {
    @Autowired
    stu_courseMapper mapper;

    public int findcount(int courseid) {
        return mapper.findcount(courseid);
    }

    public List<studentregistermodel> findstudentregistermodel(int courseinfoid, int day_of_week, int week_of_semester, int lesson_of_day) {
        return mapper.findstudentregistermodel(courseinfoid, day_of_week, week_of_semester, lesson_of_day);
    }


}
