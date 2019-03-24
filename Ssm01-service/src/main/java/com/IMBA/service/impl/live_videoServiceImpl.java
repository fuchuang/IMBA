package com.IMBA.service.impl;

import com.IMBA.dao.live_videoMapper;
import com.IMBA.entity.live_video;
import com.IMBA.model.livemodel;
import com.IMBA.service.live_videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*@Service("live_videoService")*/
public class live_videoServiceImpl implements live_videoService {
    @Autowired
    live_videoMapper liveVideoMapper;

    public  List<livemodel> findvidebylive_status(int live_status) {
        return liveVideoMapper.findvidebylive_status(live_status);
    }

    public live_video findlive_videobyid(int id) {
        return liveVideoMapper.findlive_videobyid(id);
    }

    public int updatelive_status(boolean live_status, int id) {
        return liveVideoMapper.updatelive_status(live_status,id);
    }

    public int insert(live_video record) {
        return liveVideoMapper.insert(record);
    }

    public int updatewatch_nums(int id) {
        return liveVideoMapper.updatewatch_nums(id);
    }
}
