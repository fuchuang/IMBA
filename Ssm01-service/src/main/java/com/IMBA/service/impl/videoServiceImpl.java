package com.IMBA.service.impl;

import com.IMBA.dao.videoMapper;
import com.IMBA.entity.video;
import com.IMBA.service.videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("videoService")
public class videoServiceImpl implements videoService {
    @Autowired
    videoMapper mapper;

    public int insert(video record) {
        return mapper.insert(record);
    }

    public String findvideo(int id) {
        return mapper.findvideo(id);
    }
}
