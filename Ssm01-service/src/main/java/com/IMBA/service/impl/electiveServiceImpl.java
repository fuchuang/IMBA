package com.IMBA.service.impl;

import com.IMBA.dao.electiveMapper;
import com.IMBA.service.electiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("electiveService")
public class electiveServiceImpl implements electiveService {
    @Autowired
    electiveMapper electivemapper;
}
