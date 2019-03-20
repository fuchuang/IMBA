package com.IMBA.dao;

import com.IMBA.entity.stu_teacher;

public interface stu_teacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(stu_teacher record);

    int insertSelective(stu_teacher record);

    stu_teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(stu_teacher record);

    int updateByPrimaryKey(stu_teacher record);
}