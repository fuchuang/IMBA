package com.IMBA.service.impl;

import com.IMBA.dao.postsMapper;
import com.IMBA.service.postsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postsService")
public class postsServiceImpl implements postsService {
    @Autowired
    postsMapper mapper;
}
