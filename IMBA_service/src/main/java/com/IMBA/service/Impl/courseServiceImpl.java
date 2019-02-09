package com.IMBA.service.Impl;

import com.IMBA.dao.courseMapper;
import com.IMBA.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("courseService")
public class courseServiceImpl implements courseService {
    @Autowired
    courseMapper coursemapper;
}
