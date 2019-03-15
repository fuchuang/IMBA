package com.IMBA.service.impl;

import com.IMBA.dao.video_series_likeMapper;
import com.IMBA.entity.video_series_like;
import com.IMBA.service.video_series_likeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Video_series_likeServiceImpl implements video_series_likeService {
    @Autowired
    video_series_likeMapper videoSerieslikeMapper;

    public  int insert(video_series_like record){
        return videoSerieslikeMapper.insert(record);
    }

    public int findlikesbystu_idandvideo_series_id(int stu_id, int series_id) {
        return videoSerieslikeMapper.findlikesbystu_idandvideo_series_id(stu_id, series_id);
    }

    public int findcoutbyvideo_series_id(int series_id) {
        return videoSerieslikeMapper.findcoutbyvideo_series_id(series_id);
    }
}
