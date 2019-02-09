package com.IMBA.dao;

import com.IMBA.entity.teacher;

public interface teacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(teacher record);

    int insertSelective(teacher record);

    teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(teacher record);

    int updateByPrimaryKey(teacher record);
}