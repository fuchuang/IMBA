package com.IMBA.service.impl;

import com.IMBA.dao.teacher_courseMapper;
import com.IMBA.service.teacher_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service("teacher_courseService")*/
public class teacher_courseServiceImpl implements teacher_courseService {
    @Autowired
    teacher_courseMapper mapper;

}
