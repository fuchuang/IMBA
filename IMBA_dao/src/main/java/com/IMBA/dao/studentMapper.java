package com.IMBA.dao;

import com.IMBA.entity.student;
import com.IMBA.entity.studentKey;

public interface studentMapper {
    int deleteByPrimaryKey(studentKey key);

    int insert(student record);

    int insertSelective(student record);

    student selectByPrimaryKey(studentKey key);

    int updateByPrimaryKeySelective(student record);

    int updateByPrimaryKey(student record);
}