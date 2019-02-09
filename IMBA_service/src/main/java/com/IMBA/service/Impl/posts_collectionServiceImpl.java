package com.IMBA.service.Impl;

import com.IMBA.dao.posts_collectionMapper;
import com.IMBA.service.posts_collectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("posts_collectionService")
public class posts_collectionServiceImpl implements posts_collectionService {
    @Autowired
    posts_collectionMapper mapper;
}
