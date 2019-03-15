package com.IMBA.service.impl;

import com.IMBA.dao.video_collectionsMapper;
import com.IMBA.entity.video_collections;
import com.IMBA.service.video_collectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("video_collectionsService")
public class video_collectionsServiceImpl implements video_collectionsService {
    @Autowired
    video_collectionsMapper mapper;

    public int insert(video_collections record) {
        return mapper.insert(record);
    }

    public int findcollectionsbystu_idandvideo_series_id(int stu_id, int video_series_id) {
        return mapper.findcollectionsbystu_idandvideo_series_id(stu_id, video_series_id);
    }
}
