package com.IMBA.service;

import com.IMBA.entity.student;

import java.util.List;

public interface studentService {
    public student findstudentBystuid(String stuid);
    public List<student> selectall();
    public student findstudentByid(int id);
    public int findmajor(int stuid);



}
