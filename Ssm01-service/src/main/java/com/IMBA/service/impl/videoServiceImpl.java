package com.IMBA.service.impl;

import com.IMBA.dao.videoMapper;
import com.IMBA.service.videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("videoService")
public class videoServiceImpl implements videoService {
    @Autowired
    videoMapper mapper;

}
