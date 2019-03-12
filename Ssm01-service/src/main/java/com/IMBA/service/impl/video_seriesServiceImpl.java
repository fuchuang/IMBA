package com.IMBA.service.impl;

import com.IMBA.dao.video_seriesMapper;
import com.IMBA.entity.video_series;
import com.IMBA.model.adminlikemsgmodel;
import com.IMBA.model.videolistmodel;
import com.IMBA.model.videowatchnumsrank;
import com.IMBA.service.video_seriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("video_seriesService")
public class video_seriesServiceImpl implements
        video_seriesService {
    @Autowired
    video_seriesMapper mapper;

    public int insert(video_series record) {
        return mapper.insert(record);
    }

    public List<videolistmodel> findvideoList(int video_seriesid) {
        return mapper.findvideoList(video_seriesid);
    }

    public List<video_series> findvideo_seriesList(String course_type) {
        return mapper.findvideo_seriesList(course_type);
    }

    public int updatewathing_num(int video_series_id){
        return mapper.updatewathing_num(video_series_id);
    }

    public List<video_series> findvideo_seriesListbycollection_stu_id(int stu_id) {
        return mapper.findvideo_seriesListbycollection_stu_id(stu_id);
    }

    public List<videowatchnumsrank> findbywatchnums() {
        return mapper.findbywatchnums();
    }

    public List<adminlikemsgmodel> findlikenums() {
        return mapper.findlikenums();
    }

    public List<video_series> findvideo_seriesListbyrecord_stu_id(int stu_id) {
        return mapper.findvideo_seriesListbyrecord_stu_id(stu_id);
    }
}
