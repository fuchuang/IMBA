package com.IMBA.service.impl;

import com.IMBA.dao.postsMapper;
import com.IMBA.entity.posts;
import com.IMBA.service.postsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postsService")
public class postsServiceImpl implements postsService {
    @Autowired
    postsMapper mapper;

    public List<posts> getViewedRecently(int stuId) {
        List<posts> list=mapper.selectViewd(stuId);
        return list;
    }

    public List<posts> getSentPosts(int stuId) {
        List<posts> list=mapper.selectPosted(stuId);
        return list;
    }

    public List<posts> getLikedPosts(int stuId) {
        List<posts> list=mapper.selectLiked(stuId);
        return list;
    }
}
