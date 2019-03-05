package com.IMBA.service;

import com.IMBA.dto.studentInfo;
import com.IMBA.entity.student;

public interface studentService {
    student findbystuid(int stuid);

    int insertSelective(student record);

    int insertAndGetId(student record);

    boolean updateSignature(int stuId,String content);

    studentInfo getStuInfoById(int stuId);







}
