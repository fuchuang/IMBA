package com.IMBA.service.impl;

import com.IMBA.dao.schedule_backgroundMapper;
import com.IMBA.dao.studentMapper;
import com.IMBA.entity.student;
import com.IMBA.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper StuMapper;


    public student findbystuid(int stuid) {
        student s=StuMapper.findByStuId(stuid);
        if(s!=null){
            return s;
        }
        return null;
    }

    public int insertSelective(student record) {
        StuMapper.insertSelective(record);
        return  StuMapper.insertSelective(record);
    }

    public int insertAndGetId(student record){
        StuMapper.insertAndGetId(record);
        return record.getId();
    }

    public boolean updateSignature(int stuId, String content) {
        student s=findbystuid(stuId);
        if(s!=null && !(content.trim()).equals("")){
            s.setPersonalizedSignatures(content);
            StuMapper.updateByPrimaryKeySelective(s);
            return true;
        }else {
            return false;
        }
    }
}
