package com.IMBA.dao;

import com.IMBA.entity.posts;
import com.IMBA.entity.postsKey;

public interface postsMapper {
    posts findbypostid(int id);
    int deleteByPrimaryKey(postsKey key);

    int insert(posts record);

    int insertSelective(posts record);

    posts selectByPrimaryKey(postsKey key);

    int updateByPrimaryKeySelective(posts record);

    int updateByPrimaryKeyWithBLOBs(posts record);

    int updateByPrimaryKey(posts record);
}