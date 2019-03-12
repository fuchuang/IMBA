package com.IMBA.service;

import com.IMBA.entity.video;

public interface videoService  {
    int insert(video record);
    String findvideo(int id);
}
