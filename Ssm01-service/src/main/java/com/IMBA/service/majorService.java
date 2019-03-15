package com.IMBA.service;

import com.IMBA.entity.major;

import java.util.List;

public interface majorService {
    major findmajorname(int stu_id);
    List<major> findAll();

    //添加专业 并赋值给major对象id
    public int addMajor(major record);

    //通过id 查询详细信息
    major findById(int id);

}
