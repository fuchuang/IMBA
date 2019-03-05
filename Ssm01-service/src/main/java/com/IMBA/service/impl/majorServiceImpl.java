package com.IMBA.service.impl;

import com.IMBA.dao.majorMapper;
import com.IMBA.entity.major;
import com.IMBA.service.majorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("majorService")
public class majorServiceImpl implements majorService {
    @Autowired
    majorMapper majormapper;

    public int addMajor(major record) {
       // if(record.getGrade().equals("")||record.getClasses().equals(""))return -1;
        majormapper.insertAndGetId(record);
        return record.getId();
    }

    public major findById(int id) {
        major result=majormapper.selectByPrimaryKey(id);
        return result;
    }
}
