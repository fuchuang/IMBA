package com.IMBA.dao;

import com.IMBA.dto.watchedVideoDto;
import com.IMBA.entity.video_series;

import java.util.List;

public interface video_seriesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(video_series record);

    int insertSelective(video_series record);

    video_series selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(video_series record);

    int updateByPrimaryKey(video_series record);

    List<video_series> selectCollection(Integer stuId);

    //查找最近浏览单个视频记录
    List<watchedVideoDto> selectWatchedVideo(Integer stuId);
}