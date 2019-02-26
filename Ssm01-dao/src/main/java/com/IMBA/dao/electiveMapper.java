package com.IMBA.dao;

import com.IMBA.entity.elective;
import com.IMBA.entity.electiveKey;

import java.util.List;

public interface electiveMapper {
    int deleteByPrimaryKey(electiveKey key);

    int insert(elective record);

    int insertSelective(elective record);

    elective selectByPrimaryKey(electiveKey key);

    int updateByPrimaryKeySelective(elective record);

    int updateByPrimaryKey(elective record);

    List<elective> selectCollection(Integer stuId);
}