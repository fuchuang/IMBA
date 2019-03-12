package com.IMBA.dao;

import com.IMBA.entity.video;
import com.IMBA.entity.videoKey;
import com.IMBA.model.videolistmodel;

import java.util.List;

public interface videoMapper {



    String findvideo(int id);
    int deleteByPrimaryKey(videoKey key);

    int insert(video record);

    int insertSelective(video record);

    video selectByPrimaryKey(videoKey key);

    int updateByPrimaryKeySelective(video record);

    int updateByPrimaryKey(video record);
}