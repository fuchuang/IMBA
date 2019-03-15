package com.IMBA.dao;

import com.IMBA.entity.course;
import com.IMBA.entity.courseKey;
import com.IMBA.model.coursemodel;

import java.util.List;

public interface courseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(course record);

    int insertSelective(course record);

    course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(course record);

    int updateByPrimaryKey(course record);

    int insertAndGetId(course record);

    course selectByCouseId( Integer id);

    course selectExamCourseByCouseId(Integer id);


}