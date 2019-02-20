package com.IMBA.weui.controller.communitycontroller;

import com.IMBA.service.registerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class studentController {
    @Autowired
    registerService registerservice;
    //课程列表
    //考勤状况
    @RequestMapping(value = "/student/reggisterstatus")
    @ResponseBody()
    JSONObject reggisterstutssid(@RequestParam("course_id")int course_id,@RequestParam("status")String status ,HttpServletRequest request){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        int count =registerservice.findbystatus(status,student_id);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",count);
        return  JSONObject.fromObject(msg);


    }


}
