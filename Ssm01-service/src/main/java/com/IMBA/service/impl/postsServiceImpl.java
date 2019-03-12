package com.IMBA.service.impl;

import com.IMBA.dao.postsMapper;
import com.IMBA.entity.posts;
import com.IMBA.service.postsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postsService")
public class postsServiceImpl implements postsService {
    @Autowired
    postsMapper mapper;

    public int insert(posts record) {

        return mapper.insert(record);
    }

    public posts findbypostid(int id) {
        return mapper.findbypostid(id);
    }

    public int findcount() {
        return mapper.findcount();
    }
}
