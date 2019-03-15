package com.IMBA.service;

import com.IMBA.entity.posts_collectionKey;

public interface posts_collectionService {
    posts_collectionKey findbypostidandstuid(int postid,int stuid);
    int insert(posts_collectionKey record);
}
