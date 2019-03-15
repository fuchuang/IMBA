package com.IMBA.service;

import com.IMBA.entity.posts;

import java.util.List;

public interface postsService {
    int insert(posts record);
    posts findbypostid(int id);
    int findcount();


    //查找最近浏览帖子
    List<posts> getViewedRecently(int stuId);

    //查找已发的帖子
    List<posts> getSentPosts(int stuId);

    //查找喜欢的帖子
    List<posts> getLikedPosts(int stuId);

}
