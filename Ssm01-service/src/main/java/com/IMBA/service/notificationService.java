package com.IMBA.service;

import com.IMBA.dto.noticesDto;
import com.IMBA.entity.notification;

import java.util.List;

public interface notificationService {
    //查找学生收藏的通知列表
    List<noticesDto> findCollectionsByStuId(int stuId, int offset, int limit);
    //通知详情
    notification noticesDetail(int stuId, int id);

    int getCollectionCount(int stuId);



    //查找收到的通知列表
    List<noticesDto> findNoticesByStuId(int stuId, int offset, int limit);

    int getNoticesCount(int stuId);

    //添加通知
    boolean addNotices(notification notices);

    //查看最近浏览的通知
    List<noticesDto> getViewRecently(int stuId,int offset,int limit);

    int getViewRecentlyCount(int stuId);


    //添加收藏
    boolean addCollect(int stuId,int noticeId);

    //取消收藏
    boolean cancelCollect(int stuId,int noticeId);
}
