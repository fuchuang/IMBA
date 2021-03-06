package com.IMBA.service;

import com.IMBA.entity.video_series;
import com.IMBA.model.adminlikemsgmodel;
import com.IMBA.model.videolistmodel;
import com.IMBA.model.videowatchnumsrank;

import java.util.List;

public interface video_seriesService {
    int insert(video_series record);
    List<videolistmodel> findvideoList(int video_seriesid);
    List<video_series>findvideo_seriesList(String course_type);
    int updatewathing_num( int video_series_id);
    List<video_series> findvideo_seriesListbyrecord_stu_id(int stu_id);
    List<video_series> findvideo_seriesListbycollection_stu_id(int stu_id);
    List<videowatchnumsrank>findbywatchnums();
    List<adminlikemsgmodel>findlikenums();


}
