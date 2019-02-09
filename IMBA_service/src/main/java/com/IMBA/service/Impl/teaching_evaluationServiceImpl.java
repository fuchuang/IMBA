package com.IMBA.service.Impl;

import com.IMBA.dao.teaching_evaluationMapper;
import com.IMBA.service.teaching_evaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teaching_evaluationService")
public class teaching_evaluationServiceImpl implements teaching_evaluationService {
    @Autowired
    teaching_evaluationMapper mapper;
}
