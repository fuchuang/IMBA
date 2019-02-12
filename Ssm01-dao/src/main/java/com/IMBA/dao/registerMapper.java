package com.IMBA.dao;

import com.IMBA.entity.register;
import com.IMBA.entity.registerKey;

public interface registerMapper {
    int deleteByPrimaryKey(registerKey key);

    int insert(register record);

    int insertSelective(register record);

    register selectByPrimaryKey(registerKey key);

    int updateByPrimaryKeySelective(register record);

    int updateByPrimaryKey(register record);
}