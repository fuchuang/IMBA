package com.IMBA.service.impl;

import com.IMBA.dao.stu_courseMapper;
import com.IMBA.service.stu_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stu_courseService")
public class stu_courseServiceImpl implements stu_courseService {
    @Autowired
    stu_courseMapper mapper;
}
