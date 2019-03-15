package com.IMBA.dao;

import com.IMBA.entity.info_functions;
import com.IMBA.entity.info_functionsKey;

public interface info_functionsMapper {
    int deleteByPrimaryKey(info_functionsKey key);

    int insert(info_functions record);

    int insertSelective(info_functions record);

    info_functions selectByPrimaryKey(info_functionsKey key);

    int updateByPrimaryKeySelective(info_functions record);

    int updateByPrimaryKey(info_functions record);
}