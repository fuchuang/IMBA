package com.IMBA.service.impl;

import com.IMBA.dao.stu_examMapper;
import com.IMBA.service.stu_examService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stu_examService")
public class stu_examServiceImpl implements stu_examService {
    @Autowired
    stu_examMapper mapper;

    public boolean addToSchedule(int stuExamId) {
        return false;
    }
}
