package com.IMBA.dao;

import com.IMBA.entity.video_series_like;

public interface video_series_likeMapper {


    //点赞
    int insert(video_series_like record);
    //是否可以赞
    int findlikesbystu_idandvideo_series_id(int stu_id,int series_id);

    //查找点赞数
    int findcoutbyvideo_series_id(int series_id);


}