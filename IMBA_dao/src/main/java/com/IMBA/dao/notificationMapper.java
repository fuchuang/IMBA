package com.IMBA.dao;

import com.IMBA.entity.notification;

public interface notificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(notification record);

    int insertSelective(notification record);

    notification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(notification record);

    int updateByPrimaryKeyWithBLOBs(notification record);

    int updateByPrimaryKey(notification record);
}