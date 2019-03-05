package com.IMBA.service;

import com.IMBA.entity.major;

import java.util.List;

public interface majorService {
    major findmajorname(int stu_id);
    List<major> findAll();
}
