package com.IMBA.dao;

import com.IMBA.entity.posts_collectionKey;

public interface posts_collectionMapper {
    int deleteByPrimaryKey(posts_collectionKey key);

    int insert(posts_collectionKey record);

    int insertSelective(posts_collectionKey record);
}