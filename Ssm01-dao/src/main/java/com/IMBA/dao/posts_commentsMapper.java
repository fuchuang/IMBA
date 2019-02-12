package com.IMBA.dao;

import com.IMBA.entity.posts_comments;
import com.IMBA.entity.posts_commentsKey;

public interface posts_commentsMapper {
    int deleteByPrimaryKey(posts_commentsKey key);

    int insert(posts_comments record);

    int insertSelective(posts_comments record);

    posts_comments selectByPrimaryKey(posts_commentsKey key);

    int updateByPrimaryKeySelective(posts_comments record);

    int updateByPrimaryKey(posts_comments record);
}