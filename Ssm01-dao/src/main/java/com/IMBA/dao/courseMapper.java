package com.IMBA.dao;

import com.IMBA.entity.course;
import com.IMBA.entity.courseKey;
import com.IMBA.model.coursemodel;

import java.util.List;

public interface courseMapper {



    int deleteByPrimaryKey(courseKey key);

    int insert(course record);

    int insertSelective(course record);

    course selectByPrimaryKey(courseKey key);

    int updateByPrimaryKeySelective(course record);

    int updateByPrimaryKey(course record);
}