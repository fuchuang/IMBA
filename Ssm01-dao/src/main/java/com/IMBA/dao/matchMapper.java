package com.IMBA.dao;

import com.IMBA.entity.match;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface matchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(match record);

    int insertSelective(match record);

    match selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(match record);

    int updateByPrimaryKeyWithBLOBs(match record);

    int updateByPrimaryKey(match record);

    List<match> selectByType(@Param("matchType") Integer matchType,@Param("offset") Integer offset,@Param("num") Integer num);

    int getCount(int matchType);


}