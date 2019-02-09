package com.IMBA.controller.LoginRegisterController;

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


    }


}
