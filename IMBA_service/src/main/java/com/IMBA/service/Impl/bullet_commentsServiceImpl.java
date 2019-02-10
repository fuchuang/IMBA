package com.IMBA.service.Impl;

import com.IMBA.dao.bullet_commentsMapper;
import com.IMBA.service.bullet_commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service()
public class bullet_commentsServiceImpl implements bullet_commentsService {
        @Resource
        private bullet_commentsMapper bullet_commentsMapper;




}
