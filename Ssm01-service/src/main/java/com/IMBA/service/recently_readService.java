package com.IMBA.service;

import com.IMBA.entity.recently_readKey;

public interface recently_readService {
    recently_readKey findbypostid(int postid, int stuid);
    int insert(recently_readKey record);
}
