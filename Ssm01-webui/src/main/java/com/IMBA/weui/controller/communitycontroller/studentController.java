package com.IMBA.weui.controller.communitycontroller;

import com.IMBA.entity.teacher_notification;
import com.IMBA.model.coursemodel;
import com.IMBA.model.registermodel;
import com.IMBA.service.*;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class studentController {
    @Autowired
    registerService registerservice;
    @Autowired
    courseService courseservice;
    @Autowired
    stu_courseService stuCourseService;
    @Autowired
    teacher_notificationService teacherNotificationService;
    @Autowired
    course_infoService courseInfoService;

    //课程列表
    @RequiresRoles("student")
    @RequestMapping(value = "/student/courselist")
    @ResponseBody()
    JSONObject courselist(@RequestParam(value = "course_year",defaultValue = "2018年")String course_year ,HttpServletRequest request) {
        //时间
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        List<coursemodel>coursemodelList=courseInfoService.findCouseMsg(student_id,course_year);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",coursemodelList);
        return  JSONObject.fromObject(msg);


    }
    //考勤状况
    @RequiresRoles("student")
    @RequestMapping(value = "/student/reggisterstatus")
    @ResponseBody()
    JSONObject reggisterstutssid(@RequestParam("courseinfoid")int courseinfoid,HttpServletRequest request){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        String latestatus="late";
        int latecount =registerservice.findbystatus(latestatus,student_id,courseinfoid);
        String truantstatus="truant";
        int truantcount =registerservice.findbystatus(truantstatus,student_id,courseinfoid);
        //总课时
        int total=courseInfoService.findcourse_hourbycourid(courseinfoid);
        registermodel registerModel=new registermodel();
        registerModel.setLatecount(latecount);
        registerModel.setTruantcount(truantcount);
        registerModel.setTotal(total);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",registerModel);
        return  JSONObject.fromObject(msg);
    }
    //查看通知
    @RequiresRoles("student")
    @RequestMapping(value = "/student/notification")
    @ResponseBody()
    JSONObject notification(@RequestParam(value = "courseinfoid" ,defaultValue = "1")int courseinfoid){
        List<teacher_notification>teacherNotifications=teacherNotificationService.findbycourseid(courseinfoid);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",teacherNotifications);
        return  JSONObject.fromObject(msg);
    }


}
