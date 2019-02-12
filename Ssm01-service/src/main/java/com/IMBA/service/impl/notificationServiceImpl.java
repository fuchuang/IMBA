package com.IMBA.service.impl;

import com.IMBA.dao.notificationMapper;
import com.IMBA.service.notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("notificationService")
public class notificationServiceImpl implements notificationService {
    @Autowired
    notificationMapper mapper;
}
