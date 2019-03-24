package com.IMBA.service.impl;

import com.IMBA.dao.registerMapper;
import com.IMBA.entity.register;
import com.IMBA.service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*@Service("registerService")*/
public class registerServiceImpl implements registerService {
    @Autowired
    registerMapper mapper;

    public int insert(register record) {
        mapper.insert(record);
        return 0;
    }

    public int findbystatus(String status, int id, int course_id) {
        return mapper.findbystatus(status, id,course_id);
    }

    public List<String> findstudent(String status, int major) {
        return mapper.findstudent(status,major);
    }

    public int findstudentbystu_idandcourse_id(int stu_id, int course_id) {
        return mapper.findstudentbystu_idandcourse_id(stu_id, course_id);
    }

    public int updateByPrimaryKeySelective(register record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

}
