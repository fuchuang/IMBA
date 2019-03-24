package com.IMBA.service.impl;

import com.IMBA.dao.stu_adminMapper;
import com.IMBA.entity.stu_admin;
import com.IMBA.service.stu_adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service*/
public class stu_adminServiceImpl implements stu_adminService {
    @Autowired
    stu_adminMapper stuAdminMapper;

    public int insert(stu_admin record) {
        return stuAdminMapper.insert(record);
    }

    public int isadmin(int stu_id, int course_id) {
        return stuAdminMapper.isadmin(stu_id, course_id);
    }

    public int deleteadmin(int stu_id, int course_id) {
        return stuAdminMapper.deleteadmin(stu_id, course_id);
    }
}
