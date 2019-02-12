package com.IMBA.service.impl;

import com.IMBA.dao.memoMapper;
import com.IMBA.service.memoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memoService")
public class memoServiceImpl implements memoService {
    @Autowired
    memoMapper mapper;
}
