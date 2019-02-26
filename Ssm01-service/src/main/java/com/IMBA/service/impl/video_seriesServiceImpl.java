package com.IMBA.service.impl;

import com.IMBA.dao.video_seriesMapper;
import com.IMBA.dto.watchedVideoDto;
import com.IMBA.entity.video_series;
import com.IMBA.service.video_seriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("video_seriesService")
public class video_seriesServiceImpl implements video_seriesService {
    @Autowired
    video_seriesMapper mapper;

    public List<video_series> findCollectionsByStuId(int stuId) {
        List list=mapper.selectCollection(stuId);
        return list;
    }

    public List<watchedVideoDto> watchedRecentlyByStuId(int stuId) {
        List<watchedVideoDto> list=mapper.selectWatchedVideo(stuId);
        return list;
    }
}
