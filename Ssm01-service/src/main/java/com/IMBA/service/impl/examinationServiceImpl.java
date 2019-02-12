package com.IMBA.service.impl;

import com.IMBA.dao.examinationMapper;
import com.IMBA.service.examinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("examinationService")
public class examinationServiceImpl implements examinationService {
    @Autowired
    examinationMapper examinationmapper;
}
