package com.IMBA.service.impl;

import com.IMBA.dao.studentMapper;
import com.IMBA.entity.student;
import com.IMBA.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper mapper;

    public student findbystuid(int stuid) {
        return null;
    }

    public int insertSelective(student record) {
        mapper.insertSelective(record);
        return  mapper.insertSelective(record);
    }
}