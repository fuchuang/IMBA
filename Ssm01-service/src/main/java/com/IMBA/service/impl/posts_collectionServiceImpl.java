package com.IMBA.service.impl;

import com.IMBA.dao.posts_collectionMapper;
import com.IMBA.entity.posts_collectionKey;
import com.IMBA.service.posts_collectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("posts_collectionService")
public class posts_collectionServiceImpl implements posts_collectionService {
    @Autowired
    posts_collectionMapper mapper;



    public posts_collectionKey findbypostidandstuid(int postid, int stuid) {
        return mapper.findbypostidandstuid(postid, stuid);
    }

    public int insert(posts_collectionKey record) {
        mapper.insert(record);
        return 0;
    }
}
