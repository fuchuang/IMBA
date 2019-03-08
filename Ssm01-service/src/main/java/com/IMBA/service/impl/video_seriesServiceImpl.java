package com.IMBA.service.impl;

import com.IMBA.dao.video_seriesMapper;
import com.IMBA.entity.video_series;
import com.IMBA.model.videolistmodel;
import com.IMBA.service.video_seriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("video_seriesService")
public class video_seriesServiceImpl implements video_seriesService {
    @Autowired
    video_seriesMapper mapper;

    public int insert(video_series record) {
        return mapper.insert(record);
    }

    public List<videolistmodel> findvideoList(int video_seriesid) {
        return mapper.findvideoList(video_seriesid);
    }
}
