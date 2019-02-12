package com.IMBA.dao;

import com.IMBA.entity.major;

public interface majorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(major record);

    int insertSelective(major record);

    major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(major record);

    int updateByPrimaryKey(major record);
}