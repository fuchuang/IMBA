package com.IMBA.dao;

import com.IMBA.entity.stu_exam;
import com.IMBA.entity.stu_examKey;

public interface stu_examMapper {
    int deleteByPrimaryKey(stu_examKey key);

    int insert(stu_exam record);

    int insertSelective(stu_exam record);

    stu_exam selectByPrimaryKey(stu_examKey key);

    int updateByPrimaryKeySelective(stu_exam record);

    int updateByPrimaryKey(stu_exam record);

    stu_exam selectByStuIdAndExamId(stu_examKey key);

    int updateIsOnScheduleById(stu_examKey key);
}