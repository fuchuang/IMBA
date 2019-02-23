package com.IMBA.service.impl;

import com.IMBA.dao.schedule_backgroundMapper;
import com.IMBA.dao.studentMapper;
import com.IMBA.entity.student;
import com.IMBA.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper StuMapper;


    public student findbystuid(int stuid) {
        return null;
    }

    public int insertSelective(student record) {
        StuMapper.insertSelective(record);
        return  StuMapper.insertSelective(record);
    }

    public int insertAndGetId(student record){
        StuMapper.insertAndGetId(record);
        return record.getId();
    }
}
