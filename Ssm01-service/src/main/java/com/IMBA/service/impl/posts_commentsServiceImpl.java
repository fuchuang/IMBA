package com.IMBA.service.impl;

import com.IMBA.dao.posts_commentsMapper;
import com.IMBA.service.posts_commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("posts_commentsService")
public class posts_commentsServiceImpl implements posts_commentsService {
    @Autowired
    posts_commentsMapper mapper;
}
