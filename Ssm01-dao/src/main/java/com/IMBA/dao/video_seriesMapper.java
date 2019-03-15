package com.IMBA.dao;

import com.IMBA.dto.watchedVideoDto;
import com.IMBA.entity.video_series;
import com.IMBA.model.adminlikemsgmodel;
import com.IMBA.model.videolistmodel;
import com.IMBA.model.videowatchnumsrank;

import java.util.List;

public interface video_seriesMapper {
    List<videolistmodel> findvideoList(int video_seriesid);
    List<video_series>findvideo_seriesList(String course_type);
    List<video_series> findvideo_seriesListbycollection_stu_id(int stu_id);
    List<video_series> findvideo_seriesListbyrecord_stu_id(int stu_id);
    int updatewathing_num( int video_series_id);
    //观看人数排名
    List<videowatchnumsrank>findbywatchnums();
    //点赞排名
    List<adminlikemsgmodel>findlikenums();



    List<video_series> selectCollection(Integer stuId);

    //查找最近浏览单个视频记录
    List<watchedVideoDto> selectWatchedVideo(Integer stuId);



    int deleteByPrimaryKey(Integer id);

    int insert(video_series record);

    int insertSelective(video_series record);

    video_series selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(video_series record);

    int updateByPrimaryKey(video_series record);
}