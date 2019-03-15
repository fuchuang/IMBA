package com.IMBA.weui.controller.LoginRegisterController;

import com.IMBA.service.clock_inService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    clock_inService clockIn;
    //登陆界面
    @RequestMapping("/user/login")
    public String Login(){
        return "login";
    }


    //确认登陆界面
    @RequestMapping("/user/CheckLogin")
    @ResponseBody
    public JSONObject CheckLoginLogin(@RequestParam(name = "stuId")String stuId, @RequestParam(name = "password")String password){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(stuId, password);
        Map<String,Object> msg=new HashMap<>();

        try {
            //执行认证操作.
            subject.login(token);
        }catch (AuthenticationException ae) {
            System.out.println("登陆失败: " + ae.getMessage());
            msg.put("msg","登陆失败: " + ae.getMessage());
            return  JSONObject.fromObject(msg);
        }

        msg.put("msg","成功跳转index" );
        return  JSONObject.fromObject(msg);
    }

}
