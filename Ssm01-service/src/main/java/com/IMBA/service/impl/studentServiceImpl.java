package com.IMBA.service.impl;

import com.IMBA.dao.studentMapper;
import com.IMBA.entity.student;
import com.IMBA.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper mapper;


    public student findstudentBystuid(String stuid) {

        return  mapper.findstudentBystuid(stuid);

    }

    public List<student> selectall() {
        return mapper.selectall();

    }


}
