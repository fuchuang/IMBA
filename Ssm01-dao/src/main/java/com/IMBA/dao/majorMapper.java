package com.IMBA.dao;

import com.IMBA.entity.major;

import java.util.List;

public interface majorMapper {
    major findmajorname(int stu_id);
    List<major> findAll();
    int deleteByPrimaryKey(Integer id);
    int insertAndGetId(major record);



    int insert(major record);

    int insertSelective(major record);

    major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(major record);

    int updateByPrimaryKey(major record);
}