package com.IMBA.service;

import com.IMBA.entity.course_files;

import java.util.List;

public interface course_filesService  {
    int insert(course_files record);
    List<course_files>findbycouser_id(int id);
    course_files fingbyid(int id);
}
