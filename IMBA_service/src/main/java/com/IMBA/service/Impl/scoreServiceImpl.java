package com.IMBA.service.Impl;

import com.IMBA.dao.scoreMapper;
import com.IMBA.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("scoreService")
public class scoreServiceImpl implements scoreService {
    @Autowired
    scoreMapper mapper;
}
