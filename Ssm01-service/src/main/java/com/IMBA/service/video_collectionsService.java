package com.IMBA.service;

import com.IMBA.entity.video_collections;

public interface video_collectionsService {
    int insert(video_collections record);
    int findcollectionsbystu_idandvideo_series_id(int stu_id,int video_series_id);

}
