package com.IMBA.dao;

import com.IMBA.entity.posts;
import com.IMBA.entity.posts_collectionKey;

import java.util.List;

public interface posts_collectionMapper {

    posts_collectionKey findbypostidandstuid(int postid,int stuid);

    int deleteByPrimaryKey(posts_collectionKey key);

    int insert(posts_collectionKey record);

    int insertSelective(posts_collectionKey record);
}