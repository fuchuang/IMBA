package com.IMBA.dao;

import com.IMBA.entity.course_files;
import com.IMBA.entity.course_filesKey;

import java.util.List;

public interface course_filesMapper {
    List<course_files>findbycouser_id(int id);
    course_files fingbyid(int id);


    int deleteByPrimaryKey(course_filesKey key);

    int insert(course_files record);

    int insertSelective(course_files record);

    course_files selectByPrimaryKey(course_filesKey key);

    int updateByPrimaryKeySelective(course_files record);

    int updateByPrimaryKey(course_files record);
}