package com.IMBA.dao;

import com.IMBA.entity.score;
import com.IMBA.entity.scoreKey;

public interface scoreMapper {
    int deleteByPrimaryKey(scoreKey key);

    int insert(score record);

    int insertSelective(score record);

    score selectByPrimaryKey(scoreKey key);

    int updateByPrimaryKeySelective(score record);

    int updateByPrimaryKey(score record);
}