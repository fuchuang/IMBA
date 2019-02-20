package com.IMBA.service;

import com.IMBA.entity.posts;

public interface postsService {
    int insert(posts record);
    posts findbypostid(int id);
}
