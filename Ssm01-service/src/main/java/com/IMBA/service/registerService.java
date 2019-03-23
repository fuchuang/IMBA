package com.IMBA.service;

import com.IMBA.entity.register;

import java.util.List;

public interface registerService {
    int insert(register record);
    int findbystatus(String status,int id,int course_id);
    List<String> findstudent(String status, int major);
    int findstudentbystu_idandcourse_id(int stu_id,int course_id);
    int updateByPrimaryKeySelective(register record);
}
