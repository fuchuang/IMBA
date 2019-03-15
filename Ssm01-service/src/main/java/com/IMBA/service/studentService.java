package com.IMBA.service;

import com.IMBA.dto.studentInfo;
import com.IMBA.entity.student;

import java.util.List;

public interface studentService {
    public student findstudentBystuid(String stuid);
    public List<student> selectall();
    public student findstudentByid(int id);
    public int findmajor(int stuid);

    student findbystuid(int stuid);

    int insertSelective(student record);

    int insertAndGetId(student record);

    boolean updateSignature(int stuId,String content);

  /*  studentInfo getStuInfoById(int stuId);*/

}
