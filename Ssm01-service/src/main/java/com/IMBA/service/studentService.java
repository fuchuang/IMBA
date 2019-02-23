package com.IMBA.service;

import com.IMBA.entity.student;

public interface studentService {
    public student findbystuid(int stuid);
    int insertSelective(student record);
    public int insertAndGetId(student record);

}
