package com.IMBA.service;

import com.IMBA.entity.live_video;
import com.IMBA.model.livemodel;

import java.util.List;

public interface live_videoService {
    List<livemodel> findvidebylive_status(int live_status);
    //观看
    live_video findlive_videobyid(int id);
    //录制结束更新
    int updatelive_status(boolean live_status,int id);
    int insert(live_video record);
    int updatewatch_nums(int id);


}
