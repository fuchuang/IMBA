package com.IMBA.service.impl;


import com.IMBA.dao.video_recordMapper;
import com.IMBA.entity.video_record;
import com.IMBA.service.video_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class video_recordServiceImpl implements video_recordService {
    @Autowired
    video_recordMapper mapper;

    public int insert(video_record record) {
        return mapper.insert(record);
    }

    public int findvideo_recordbystu_idandvideo_id(int stu_id, int video_id) {
        return mapper.findvideo_recordbystu_idandvideo_id(stu_id,video_id);
    }

    public int updatewatch_progressbystu_idandvideo_id(video_record record) {
        return mapper.updatewatch_progressbystu_idandvideo_id(record.getStudentId(),record.getVideoId(),record.getWatchProgress());
    }

    public int findvideo_recordbystu_idandvideo_idandwatch_progress(int stu_id, int video_id, float watch_progress) {
        return mapper.findvideo_recordbystu_idandvideo_idandwatch_progress(stu_id, video_id, watch_progress);
    }

    public int findvideo_bystu_idandwatch_progress(int stu_id, float watch_progress) {
        return mapper.findvideo_bystu_idandwatch_progress(stu_id, watch_progress);
    }
}
