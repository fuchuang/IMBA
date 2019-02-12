package com.IMBA.service.impl;

import com.IMBA.dao.bullet_commentsMapper;
import com.IMBA.entity.clock_in;
import com.IMBA.service.bullet_commentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service()
public class bullet_commentsServiceImpl implements bullet_commentsService {
        @Resource
        private bullet_commentsMapper bullet_commentsMapper;



}
