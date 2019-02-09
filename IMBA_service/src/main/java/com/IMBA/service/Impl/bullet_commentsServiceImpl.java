package com.IMBA.service.Impl;

import com.IMBA.dao.bullet_commentsMapper;
import com.IMBA.service.bullet_commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bullet_commentsService")
public class bullet_commentsServiceImpl implements bullet_commentsService {
        @Autowired
        private bullet_commentsMapper bullet_commentsMapper;



}
