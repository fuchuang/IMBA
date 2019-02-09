package com.IMBA.service.Impl;

import com.IMBA.dao.stu_notificationMapper;
import com.IMBA.service.stu_notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stu_notificationService")
public class stu_notificationServiceImpl implements stu_notificationService {
    @Autowired
    stu_notificationMapper mapper;
}
