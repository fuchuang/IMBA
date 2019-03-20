package com.IMBA.service.impl;

import com.IMBA.dao.studentMapper;
import com.IMBA.dto.studentInfo;
import com.IMBA.entity.major;
import com.IMBA.entity.student;
import com.IMBA.service.majorService;
import com.IMBA.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper mapper;
//    @Autowired
//    majorService majorService;

    public student findstudentBystuid(String stuid) {

        return  mapper.findstudentBystuid(stuid);

    }

    public List<student> selectall() {
        return mapper.selectall();

    }

    public student findstudentByid(int id) {
        return mapper.findstudentByid(id);
    }

    public int findmajor(int stuid) {
        return mapper.findmajor(stuid);
    }



  


    public student findbystuid(int stuid) {
        student s=mapper.findByStuId(stuid);
        return s;
    }

    public int insertSelective(student record) {
        mapper.insertSelective(record);
        return  mapper.insertSelective(record);
    }

    public int insertAndGetId(student record){
        mapper.insertAndGetId(record);
        return record.getId();
    }

    public boolean updateSignature(int stuId, String content) {
        student s=findbystuid(stuId);
        if(s!=null && !(content.trim()).equals("")){
            s.setPersonalizedSignatures(content);
            mapper.updateByPrimaryKeySelective(s);
            return true;
        }else {
            return false;
        }
    }

    public int updateIsAdmin(int stu_id, byte isadmin) {
        return mapper.updateIsAdmin(stu_id, isadmin);
    }

//    public studentInfo getStuInfoById(int stuId) {
//        student s=mapper.findByStuId(stuId);
//        if (s==null)return null;
//        major m=majorService.findById(s.getMajorId());
//        studentInfo info=new studentInfo();
//        info.setInfo(s,m);
//        return info;
//    }
}
