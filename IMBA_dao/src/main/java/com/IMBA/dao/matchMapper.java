package com.IMBA.dao;

import com.IMBA.entity.match;

public interface matchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(match record);

    int insertSelective(match record);

    match selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(match record);

    int updateByPrimaryKeyWithBLOBs(match record);

    int updateByPrimaryKey(match record);
}