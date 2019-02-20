package com.IMBA.service.impl;

import com.IMBA.dao.registerMapper;
import com.IMBA.entity.register;
import com.IMBA.service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerService")
public class registerServiceImpl implements registerService {
    @Autowired
    registerMapper mapper;

    public int insert(register record) {
        mapper.insert(record);

        return 0;
    }

    public int findbystatus(String status, int id) {
        return mapper.findbystatus(status, id);
    }
}
