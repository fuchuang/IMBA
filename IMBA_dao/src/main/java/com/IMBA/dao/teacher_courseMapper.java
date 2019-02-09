package com.IMBA.dao;

import com.IMBA.entity.teacher_courseKey;

public interface teacher_courseMapper {
    int deleteByPrimaryKey(teacher_courseKey key);

    int insert(teacher_courseKey record);

    int insertSelective(teacher_courseKey record);
}