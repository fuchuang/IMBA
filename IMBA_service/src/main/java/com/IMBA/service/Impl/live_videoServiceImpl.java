package com.IMBA.service.Impl;

import com.IMBA.dao.live_videoMapper;
import com.IMBA.service.live_videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("live_videoService")
public class live_videoServiceImpl implements live_videoService {
    @Autowired
    live_videoMapper liveVideoMapper;
}
