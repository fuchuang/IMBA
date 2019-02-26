package com.IMBA.service;

import com.IMBA.entity.elective;

import java.util.List;

public interface electiveService {
    //查找学生选课收藏列表
    List<elective> findCollectionsByStuId(int stuId);
}
