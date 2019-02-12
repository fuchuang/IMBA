package com.IMBA.service.impl;

import com.IMBA.dao.course_filesMapper;
import com.IMBA.service.course_filesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("course_filesService")
public class course_filesServiceImpl implements course_filesService {
    @Autowired
    course_filesMapper courseFilesMapper;

}
