package com.IMBA.dao;

import com.IMBA.entity.live_video;
import com.IMBA.entity.live_videoKey;

public interface live_videoMapper {
    int deleteByPrimaryKey(live_videoKey key);

    int insert(live_video record);

    int insertSelective(live_video record);

    live_video selectByPrimaryKey(live_videoKey key);

    int updateByPrimaryKeySelective(live_video record);

    int updateByPrimaryKey(live_video record);
}