package com.IMBA.service;

import com.IMBA.entity.video_record;

public interface video_recordService {
    int insert(video_record record);
    int findvideo_recordbystu_idandvideo_id(int stu_id,int video_id);
    int updatewatch_progressbystu_idandvideo_id(video_record record);
    int findvideo_recordbystu_idandvideo_idandwatch_progress(int stu_id,int video_id,float watch_progress);
    int findvideo_bystu_idandwatch_progress(int stu_id, float watch_progress);

}
