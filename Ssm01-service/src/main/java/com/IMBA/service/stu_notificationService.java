package com.IMBA.service;

import com.IMBA.entity.stu_notification;

public interface stu_notificationService {

    boolean addItem(int stuId,int noticesId);
    //更新学生-通知 1.阅读时间 2.阅读状态(在获得通知详情的时候更改) 3.是否收藏
    boolean updateItem(stu_notification record);

    stu_notification getById(int stuId,int noticeId);
}
