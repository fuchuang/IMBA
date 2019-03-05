package com.IMBA.dao;

import com.IMBA.entity.register;
import com.IMBA.entity.registerKey;

import java.util.List;

public interface registerMapper {
    int findbystatus(String status,int id,int course_id);
    List<String>findstudent(String status,int major);


    int deleteByPrimaryKey(registerKey key);

    int insert(register record);

    int insertSelective(register record);

    register selectByPrimaryKey(registerKey key);

    int updateByPrimaryKeySelective(register record);

    int updateByPrimaryKey(register record);
}