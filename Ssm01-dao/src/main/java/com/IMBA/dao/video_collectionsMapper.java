package com.IMBA.dao;

import com.IMBA.entity.video_collections;
import com.IMBA.entity.video_collectionsKey;

public interface video_collectionsMapper {
    int deleteByPrimaryKey(video_collectionsKey key);

    int insert(video_collections record);

    int insertSelective(video_collections record);

    video_collections selectByPrimaryKey(video_collectionsKey key);

    int updateByPrimaryKeySelective(video_collections record);

    int updateByPrimaryKey(video_collections record);
}