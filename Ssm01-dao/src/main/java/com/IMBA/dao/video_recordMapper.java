package com.IMBA.dao;

import com.IMBA.entity.video_record;
import com.IMBA.entity.video_recordKey;

public interface video_recordMapper {
    int findvideo_recordbystu_idandvideo_id(int stu_id,int video_id);
    int updatewatch_progressbystu_idandvideo_id(int stu_id,int video_id, float watch_progress);
    int findvideo_recordbystu_idandvideo_idandwatch_progress(int stu_id,int video_id,float watch_progress);
    int findvideo_bystu_idandwatch_progress(int stu_id, float watch_progress);

    int deleteByPrimaryKey(video_recordKey key);

    int insert(video_record record);

    int insertSelective(video_record record);

    video_record selectByPrimaryKey(video_recordKey key);
    int updateByPrimaryKey(video_record record);
}