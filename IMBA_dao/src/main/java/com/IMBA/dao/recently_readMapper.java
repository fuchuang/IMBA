package com.IMBA.dao;

import com.IMBA.entity.recently_readKey;

public interface recently_readMapper {
    int deleteByPrimaryKey(recently_readKey key);

    int insert(recently_readKey record);

    int insertSelective(recently_readKey record);
}