package com.IMBA.dao;

import com.IMBA.entity.stu_teacher_likes;

public interface stu_teacher_likesMapper {
    int deleteByPrimaryKey(stu_teacher_likes key);

    int insert(stu_teacher_likes record);

    int insertSelective(stu_teacher_likes record);

    stu_teacher_likes selectByPrimaryKey(stu_teacher_likes key);

    int updateByPrimaryKeySelective(stu_teacher_likes record);

    int updateByPrimaryKey(stu_teacher_likes record);
}
