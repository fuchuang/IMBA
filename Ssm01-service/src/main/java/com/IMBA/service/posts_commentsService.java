package com.IMBA.service;

import com.IMBA.entity.posts;
import com.IMBA.entity.posts_comments;

import java.util.List;

public interface posts_commentsService {
    int insert(posts_comments record);
    int findrowsbypostid(int id);
    List<posts_comments> findbypostid(int postid);
    int findcount();


}
