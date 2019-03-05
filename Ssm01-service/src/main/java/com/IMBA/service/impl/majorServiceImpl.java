package com.IMBA.service.impl;

import com.IMBA.dao.majorMapper;
import com.IMBA.entity.major;
import com.IMBA.service.majorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("majorService")
public class majorServiceImpl implements majorService {
    @Autowired
    majorMapper majormapper;

    public major findmajorname(int stu_id) {
        return majormapper.findmajorname(stu_id);
    }

    public List<major> findAll() {
        return majormapper.findAll();
    }
}
