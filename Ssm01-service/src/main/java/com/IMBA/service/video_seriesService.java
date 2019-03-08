package com.IMBA.service;

import com.IMBA.entity.video_series;
import com.IMBA.model.videolistmodel;

import java.util.List;

public interface video_seriesService {
    int insert(video_series record);
    List<videolistmodel> findvideoList(int video_seriesid);
}
