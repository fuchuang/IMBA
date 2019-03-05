package com.IMBA.service.impl;

import com.IMBA.dao.schedule_backgroundMapper;
import com.IMBA.dao.studentMapper;
import com.IMBA.dto.studentInfo;
import com.IMBA.entity.major;
import com.IMBA.entity.student;
import com.IMBA.service.majorService;
import com.IMBA.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper StuMapper;
    @Autowired
    majorService majorService;


    public student findbystuid(int stuid) {
        student s=StuMapper.findByStuId(stuid);
        return s;
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

    public studentInfo getStuInfoById(int stuId) {
        student s=StuMapper.findByStuId(stuId);
        if (s==null)return null;
        major m=majorService.findById(s.getMajorId());
        studentInfo info=new studentInfo();
        info.setInfo(s,m);
        return info;
    }
}
