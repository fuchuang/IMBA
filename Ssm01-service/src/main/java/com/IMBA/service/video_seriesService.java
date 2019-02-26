package com.IMBA.service;

import com.IMBA.dto.watchedVideoDto;
import com.IMBA.entity.video_series;

import java.util.List;

public interface video_seriesService {
    //查找学生视频系列收藏
    List<video_series> findCollectionsByStuId(int stuId);

    //查找学生视频浏览记录
    List<watchedVideoDto> watchedRecentlyByStuId(int stuId);
}
