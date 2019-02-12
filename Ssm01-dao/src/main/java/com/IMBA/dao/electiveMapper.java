package com.IMBA.dao;

import com.IMBA.entity.elective;
import com.IMBA.entity.electiveKey;

public interface electiveMapper {
    int deleteByPrimaryKey(electiveKey key);

    int insert(elective record);

    int insertSelective(elective record);

    elective selectByPrimaryKey(electiveKey key);

    int updateByPrimaryKeySelective(elective record);

    int updateByPrimaryKey(elective record);
}