package com.IMBA.service;

import com.IMBA.dto.noticesDto;
import com.IMBA.entity.notification;

import java.util.List;

public interface notificationService {

    //查找学生收藏的通知列表
    List<noticesDto> findCollectionsByStuId(int stuId);

    //通知详情
    notification noticesDetail(int id);

    //查找收到的通知列表
    List<noticesDto> findNoticesByStuId(int stuId);

    //添加通知
    boolean addNotices(notification notices);



}
