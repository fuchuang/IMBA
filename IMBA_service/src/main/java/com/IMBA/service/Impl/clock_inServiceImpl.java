package com.IMBA.service.Impl;

import com.IMBA.dao.clock_inMapper;
import com.IMBA.service.clock_inService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clock_inService")
public class clock_inServiceImpl implements clock_inService {
    @Autowired
    clock_inMapper clockInMapper;
}
