package com.IMBA.dao;

import com.IMBA.entity.course;
import com.IMBA.entity.course_info;
import org.springframework.stereotype.Repository;

@Repository
public interface courseInfoMapper {
    int insertSelective(course_info record);

    int deleteById(Integer id);
}