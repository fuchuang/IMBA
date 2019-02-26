package com.IMBA.service.impl;

import com.IMBA.dao.videoMapper;
import com.IMBA.entity.video;
import com.IMBA.service.videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("videoService")
public class videoServiceImpl implements videoService {
    @Autowired
    videoMapper mapper;

}
