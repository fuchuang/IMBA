package com.IMBA.controller.LoginRegisterController;

import com.IMBA.entity.student;
import com.IMBA.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginRegisterController {


    @Autowired
    private studentService studentservice;
    @RequestMapping("/Login")
    public String Login(@RequestParam("name")String name,@RequestParam("password")String password){
        student stu=new student();


        stu.setAvatarPath("xx");
        stu.setIsadmin(true);
        stu.setPassword(password);
        stu.setPersonalizedSignatures("xx");
        stu.setSex("nv");
        stu.setStuId("dd");
        stu.setStuName(name);
        studentservice.insertSelective(stu);
        return null;

    }


}
