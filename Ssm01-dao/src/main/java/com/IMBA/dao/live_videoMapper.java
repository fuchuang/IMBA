package com.IMBA.dao;

import com.IMBA.entity.live_video;
import com.IMBA.entity.live_videoKey;
import com.IMBA.model.livemodel;

import java.util.List;

public interface live_videoMapper {

    //录制列表
    List<livemodel>findvidebylive_status(int live_status);


    //观看
    live_video findlive_videobyid(int id);

    //录制结束更新
    int updatelive_status(boolean live_status,int id);
    //更新观看人数
    int updatewatch_nums(int id);


    int deleteByPrimaryKey(live_videoKey key);

    int insert(live_video record);

    int insertSelective(live_video record);

    live_video selectByPrimaryKey(live_videoKey key);

    int updateByPrimaryKeySelective(live_video record);

    int updateByPrimaryKey(live_video record);
}