package com.IMBA.service.Impl;


import com.IMBA.dao.video_recordMapper;
import com.IMBA.service.video_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class video_recordServiceImpl implements video_recordService {
    @Autowired
    video_recordMapper mapper;
}
