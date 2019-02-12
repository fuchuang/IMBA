package com.IMBA.service.impl;

import com.IMBA.dao.schedule_backgroundMapper;
import com.IMBA.service.schedule_backgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("schedule_backgroundService")
public class schedule_backgroundServiceImpl implements schedule_backgroundService {
    @Autowired
    schedule_backgroundMapper mapper;
}
