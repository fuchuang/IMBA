package com.IMBA.service.impl;

import com.IMBA.dao.video_seriesMapper;
import com.IMBA.service.video_seriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("video_seriesService")
public class video_seriesServiceImpl implements video_seriesService {
    @Autowired
    video_seriesMapper mapper;
}
