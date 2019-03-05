package com.IMBA.service.impl;

import com.IMBA.dao.teacher_notificationMapper;
import com.IMBA.entity.teacher_notification;
import com.IMBA.service.teacher_notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class teacher_notificationServiceImpl implements teacher_notificationService {
    @Autowired
    teacher_notificationMapper teacherNotificationMapper;


    public int insert(teacher_notification record) {
        return teacherNotificationMapper.insert(record);
    }

    public List<teacher_notification> findbycourseid(int courseid) {
        return teacherNotificationMapper.findbycourseid(courseid);
    }
}
