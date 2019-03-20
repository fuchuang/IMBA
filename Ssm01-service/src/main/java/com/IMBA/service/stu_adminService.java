package com.IMBA.service;

import com.IMBA.entity.stu_admin;

public interface stu_adminService {
    int insert(stu_admin record);
    int isadmin(int stu_id,int course_id);
    int deleteadmin(int stu_id,int course_id);

}
