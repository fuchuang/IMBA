package com.IMBA.dao;

import com.IMBA.entity.stu_admin;

public interface stu_adminMapper {

    //是否存在管理员权限
    int isadmin(int stu_id,int course_id);
    int deleteadmin(int stu_id,int course_id);

    int deleteByPrimaryKey(Integer id);

    int insert(stu_admin record);

    int insertSelective(stu_admin record);

    stu_admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(stu_admin record);

    int updateByPrimaryKey(stu_admin record);
}