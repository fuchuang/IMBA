package com.IMBA.dao;

import com.IMBA.entity.stu_courseKey;

public interface stu_courseMapper {
    int deleteByPrimaryKey(stu_courseKey key);

    int insert(stu_courseKey record);

    int insertSelective(stu_courseKey record);
}