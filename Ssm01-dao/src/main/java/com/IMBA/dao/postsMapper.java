package com.IMBA.dao;

import com.IMBA.entity.posts;
import com.IMBA.entity.postsKey;

import java.util.List;

public interface postsMapper {
    int deleteByPrimaryKey(postsKey key);

    int insert(posts record);

    int insertSelective(posts record);

    posts selectByPrimaryKey(postsKey key);

    int updateByPrimaryKeySelective(posts record);

    int updateByPrimaryKeyWithBLOBs(posts record);

    int updateByPrimaryKey(posts record);

    List<posts> selectViewd(Integer stuId);

    List<posts> selectPosted(Integer stuId);

    List<posts> selectLiked(Integer stuId);
}