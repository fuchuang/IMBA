package com.IMBA.dao;

import com.IMBA.entity.stu_notification;
import com.IMBA.entity.stu_notificationKey;

public interface stu_notificationMapper {
    int deleteByPrimaryKey(stu_notificationKey key);

    int insert(stu_notification record);

    int insertSelective(stu_notification record);

    stu_notification selectByPrimaryKey(stu_notificationKey key);

    int updateByPrimaryKeySelective(stu_notification record);

    int updateByPrimaryKey(stu_notification record);
}