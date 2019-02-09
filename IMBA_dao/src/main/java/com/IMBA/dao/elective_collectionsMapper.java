package com.IMBA.dao;

import com.IMBA.entity.elective_collections;
import com.IMBA.entity.elective_collectionsKey;

public interface elective_collectionsMapper {
    int deleteByPrimaryKey(elective_collectionsKey key);

    int insert(elective_collections record);

    int insertSelective(elective_collections record);

    elective_collections selectByPrimaryKey(elective_collectionsKey key);

    int updateByPrimaryKeySelective(elective_collections record);

    int updateByPrimaryKey(elective_collections record);
}