package com.IMBA.service.impl;

import com.IMBA.dao.posts_commentsMapper;
import com.IMBA.entity.posts;
import com.IMBA.entity.posts_comments;
import com.IMBA.service.posts_commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("posts_commentsService")
public class posts_commentsServiceImpl implements posts_commentsService {
    @Autowired
    posts_commentsMapper mapper;

    public int insert(posts_comments record) {
        return mapper.insert(record);
    }

    public int findrowsbypostid(int id) {
        return mapper.findrowsbypostid(id);
    }

    public List<posts_comments> findbypostid(int postid) {
        return mapper.findbypostid(postid);
    }

    public int findcount() {
        return mapper.findcount();
    }


}
