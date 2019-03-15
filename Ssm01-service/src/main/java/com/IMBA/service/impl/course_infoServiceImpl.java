package com.IMBA.service.impl;

import com.IMBA.dao.course_infoMapper;
import com.IMBA.model.coursemodel;
import com.IMBA.service.course_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class course_infoServiceImpl implements course_infoService {
    @Autowired
    course_infoMapper  courseInfoMapper;

    public List<coursemodel> findCouseMsg(int student_id, String year) {
        return courseInfoMapper.findCouseMsg(student_id, year);
    }

    public List<coursemodel> findCouseMsgbyteacherid(int teacher, String year) {
        return courseInfoMapper.findCouseMsgbyteacherid(teacher,year);
    }

    public int findcourse_hourbycourid(int courseid) {
        return courseInfoMapper.findcourse_hourbycourid(courseid);
    }

    public int findcount() {
        return courseInfoMapper.findcount();
    }
}
