package com.IMBA.service;

import com.IMBA.entity.register;

public interface registerService {
    int insert(register record);
    int findbystatus(String status,int id,int course_id);
}
