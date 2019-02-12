package com.IMBA.dao;

import com.IMBA.entity.course_files;
import com.IMBA.entity.course_filesKey;

public interface course_filesMapper {
    int deleteByPrimaryKey(course_filesKey key);

    int insert(course_files record);

    int insertSelective(course_files record);

    course_files selectByPrimaryKey(course_filesKey key);

    int updateByPrimaryKeySelective(course_files record);

    int updateByPrimaryKey(course_files record);
}