package com.IMBA.dao;

import com.IMBA.entity.teacher_notification;

import java.util.List;

public interface teacher_notificationMapper {
    int insert(teacher_notification record);
    List<teacher_notification> findbycourseid(int courseid);
}
