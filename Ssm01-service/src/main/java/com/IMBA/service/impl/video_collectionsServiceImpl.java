package com.IMBA.service.impl;

import com.IMBA.dao.video_collectionsMapper;
import com.IMBA.service.video_collectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("video_collectionsService")
public class video_collectionsServiceImpl implements video_collectionsService {
    @Autowired
    video_collectionsMapper mapper;
}
