package com.IMBA.service;

import com.IMBA.entity.video_series_like;

public interface video_series_likeService {
    int insert(video_series_like record);
    int findlikesbystu_idandvideo_series_id(int stu_id,int series_id);

    //查找点赞数
    int findcoutbyvideo_series_id(int series_id);
}
