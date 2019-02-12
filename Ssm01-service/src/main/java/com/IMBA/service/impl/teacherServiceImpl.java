package com.IMBA.service.impl;

import com.IMBA.dao.teacherMapper;
import com.IMBA.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class teacherServiceImpl implements teacherService {
    @Autowired
    teacherMapper mapper;
}
