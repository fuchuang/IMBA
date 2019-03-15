package com.IMBA.service;

import com.IMBA.entity.teacher_notification;

import java.util.List;

public interface teacher_notificationService {
    int insert( teacher_notification record);
    List<teacher_notification> findbycourseid(int courseid);

}
