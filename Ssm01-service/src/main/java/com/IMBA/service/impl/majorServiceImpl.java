package com.IMBA.service.impl;

import com.IMBA.dao.majorMapper;
import com.IMBA.service.majorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("majorService")
public class majorServiceImpl implements majorService {
    @Autowired
    majorMapper majormapper;
}
