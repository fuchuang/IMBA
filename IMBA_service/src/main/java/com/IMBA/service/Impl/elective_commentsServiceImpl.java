package com.IMBA.service.Impl;

import com.IMBA.dao.elective_commentsMapper;
import com.IMBA.service.elective_commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("elective_commentsService")
public class elective_commentsServiceImpl implements elective_commentsService {
    @Autowired
    elective_commentsMapper electiveCommentsMapper;
}
