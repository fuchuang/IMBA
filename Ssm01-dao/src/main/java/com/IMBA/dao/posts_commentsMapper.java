package com.IMBA.dao;

import com.IMBA.entity.posts;
import com.IMBA.entity.posts_comments;
import com.IMBA.entity.posts_commentsKey;

import java.util.List;

public interface posts_commentsMapper {
    int findrowsbypostid(int id);
    List<posts_comments> findbypostid(int postid);
    //贴子回复数目
    int findcount();

    int deleteByPrimaryKey(posts_commentsKey key);

    int insert(posts_comments record);

    int insertSelective(posts_comments record);

    posts_comments selectByPrimaryKey(posts_commentsKey key);

    int updateByPrimaryKeySelective(posts_comments record);

    int updateByPrimaryKey(posts_comments record);
}