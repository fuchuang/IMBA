package com.IMBA.controller.LoginRegisterController;

//import com.IMBA.entity.student;
import com.IMBA.entity.student;
import com.IMBA.service.bullet_commentsService;
import com.IMBA.service.studentService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller

public class LoginRegisterController {


    @Resource
    private bullet_commentsService bulletCommentsService;
    @Resource
    private studentService studentservice;
    @ResponseBody
    @RequestMapping("/Login")
    public Object Login(@RequestParam("name")String name,@RequestParam("password")String password){
        student stu=new student();
        stu.setAvatarPath("xx");
        stu.setIsadmin(true);
        stu.setPassword(password);
        stu.setPersonalizedSignatures("xx");
        stu.setSex("nv");
        stu.setStuId("dd");
        stu.setStuName(name);
        studentservice.insertSelective(stu);
//        JSONPObject jsonpObject = new JSONPObject(stu) ;


        return "index.jsp";

    }


}
