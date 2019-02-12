package com.IMBA.dao;

import com.IMBA.entity.video_series;

public interface video_seriesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(video_series record);

    int insertSelective(video_series record);

    video_series selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(video_series record);

    int updateByPrimaryKey(video_series record);
}