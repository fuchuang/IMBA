package com.IMBA.dao;

import com.IMBA.entity.memo;
import com.IMBA.entity.memoKey;

public interface memoMapper {
    int deleteByPrimaryKey(memoKey key);

    int insert(memo record);

    int insertSelective(memo record);

    memo selectByPrimaryKey(memoKey key);

    int updateByPrimaryKeySelective(memo record);

    int updateByPrimaryKey(memo record);
}