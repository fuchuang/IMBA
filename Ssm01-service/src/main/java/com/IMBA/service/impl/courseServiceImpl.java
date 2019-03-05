package com.IMBA.service.impl;

import com.IMBA.dao.courseMapper;
import com.IMBA.model.coursemodel;
import com.IMBA.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class courseServiceImpl implements courseService {
    @Autowired
    courseMapper coursemapper;

}
