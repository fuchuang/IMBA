package com.IMBA.service.impl;

import com.IMBA.dao.course_filesMapper;
import com.IMBA.entity.course_files;
import com.IMBA.service.course_filesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("course_filesService")
public class course_filesServiceImpl implements course_filesService {
    @Autowired
    course_filesMapper courseFilesMapper;

    public int insert(course_files record) {

        return  courseFilesMapper.insert(record);
    }

    public List<course_files> findbycouser_id(int id) {
        return courseFilesMapper.findbycouser_id(id);
    }

    public course_files fingbyid(int id) {
        return courseFilesMapper.fingbyid(id);
    }
}
