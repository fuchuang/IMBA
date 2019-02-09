package com.IMBA.dao;

import com.IMBA.entity.video_record;
import com.IMBA.entity.video_recordKey;

public interface video_recordMapper {
    int deleteByPrimaryKey(video_recordKey key);

    int insert(video_record record);

    int insertSelective(video_record record);

    video_record selectByPrimaryKey(video_recordKey key);

    int updateByPrimaryKeySelective(video_record record);

    int updateByPrimaryKey(video_record record);
}