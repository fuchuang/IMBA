package com.IMBA.service.impl;

import com.IMBA.dao.registerMapper;
import com.IMBA.service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerService")
public class registerServiceImpl implements registerService {
    @Autowired
    registerMapper mapper;
}
