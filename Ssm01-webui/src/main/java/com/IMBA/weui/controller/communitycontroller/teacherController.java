package com.IMBA.weui.controller.communitycontroller;

import com.IMBA.entity.*;
import com.IMBA.model.coursemodel;
import com.IMBA.model.studentregistermodel;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.ehcache.util.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

//考勤
@Controller

public class teacherController {

    private String filePath;

    @Value("#{conf.filepath}")

    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }


    @Autowired
    course_filesService courseFilesService;
    @Autowired
    registerService registerservice;
    @Autowired
    teacher_notificationService teachernotificationService;
    @Autowired
    courseService courseservice;
    @Autowired
    stu_courseService stuCourseService;
    @Autowired
    course_infoService courseInfoService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    majorService majorservice;
    @Autowired
    teacher_questionnaireService teacherquestionnaireService;
    @Autowired
    teaching_evaluationService teachingEvaluationService;



    public static final String SCORE_RANK = "score_rank";
    public static final String MAJOR_COLLETION="major_colletion";


    //文件上传
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/filesend",produces="text/html;charset=utf-8")
    @ResponseBody
    JSONObject filesend(@RequestParam("file") CommonsMultipartFile partFile, @RequestParam("course_id") int course_id, HttpServletRequest request) throws IOException {


        HttpSession session=request.getSession();
        int Uploaderid= (int) session.getAttribute("id");

        String path=filePath;
        String filename=partFile.getOriginalFilename();//上传时候的文件名
        File file = new File(path+"/"+filename);
        InputStream inputStream = partFile.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream, file);
        String filepath=path+"/"+filename;

        course_files record=new course_files();
        record.setFilesPath(filepath);
        record.setFilesTitle(filename);
        record.setUploadTime(new Date());
        record.setCourseId1(course_id);
        record.setUploaderId(Uploaderid);
        courseFilesService.insert(record);

        Map<String,Object> msg=new HashMap<>();

            msg.put("msg","success");
            return  JSONObject.fromObject(msg);

        //存入数据库

    }
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/upload",produces="text/html;charset=utf-8")
    String filesend(){
        return "Upload";

    }
    //发布通知
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/notification")
    @ResponseBody()
    JSONObject notification(@RequestParam(value = "courseinfoid",defaultValue = "1")int courseinfoid,
                             @RequestParam (value = "notification",defaultValue = "大家好")String notification){
        teacher_notification teacherNotification=new teacher_notification();
        teacherNotification.setCourse_id(courseinfoid);
        teacherNotification.setNotification(notification);
        teacherNotification.setPosttime(new Date());


        teachernotificationService.insert(teacherNotification);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);


    }
    //课程列表
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/courselist")
    @ResponseBody()
    JSONObject reggisterlist( @RequestParam(value = "course_year",defaultValue = "2018年")String course_year,HttpServletRequest request){
        //老师的课学生名字学生id
        HttpSession session=request.getSession();
        int teacher_id= (int) session.getAttribute("id");
        List<coursemodel>coursemodelList=  courseInfoService.findCouseMsgbyteacherid(teacher_id,course_year);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",coursemodelList);
        return  JSONObject.fromObject(msg);
    }
   //点名列表
   @RequiresRoles("teacher")
   @RequestMapping(value = "/teacher/course/reggisterlist")
   @ResponseBody()
   JSONObject reggisterlist( @RequestParam(value = "courseinfoid",defaultValue = "1")int courseinfoid,
                             @RequestParam(value = "week_of_semester",defaultValue = "1")int week_of_semester,
                             @RequestParam(value = "lesson_of_day",defaultValue = "1")int lesson_of_day,
                             @RequestParam(value = "day_of_week",defaultValue = "1")int day_of_week,
                             HttpServletRequest request){
       List<studentregistermodel>studentregistermodelList=stuCourseService.findstudentregistermodel(courseinfoid,day_of_week,week_of_semester,lesson_of_day);
       Map<String,Object> msg=new HashMap<>();
       msg.put("msg",studentregistermodelList);
       return  JSONObject.fromObject(msg);
   }


    //点名
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/reggisterid")
    @ResponseBody()
    JSONObject reggisterid(@RequestParam(value = "register_status",defaultValue = "dayoff")String register_status,
                           @RequestParam (value = "student_id",defaultValue = "1")int student_id,
                           @RequestParam(value = "course_id",defaultValue = "1")int course_id,
                           @RequestParam(value = "nums",defaultValue = "60")double nums){
        register record=new register();
        record.setRegisterStatus(register_status);
        record.setRegisterTime(new Date());
        record.setCourseId(course_id);
        record.setStudentId(student_id);
        registerservice.insert(record);
        //人数%1/num;

        double score=1/nums;

        //查找专业班级
        major mj=majorservice.findmajorname(student_id);
        String mojorcourse=mj.getGrade()+mj.getMarjorName()+mj.getClasses()+"班"+course_id;

        String mojor=mj.getGrade()+mj.getMarjorName()+mj.getClasses()+"班";
        if (register_status.equals("late")||register_status.equals("truant")){

        }else {
            redisUtil.set(MAJOR_COLLETION,mojorcourse);
            redisUtil.incrementScore(SCORE_RANK,mojor,score);
        }



        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);
    }


    //标记为管理员

    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/setadmin")
    @ResponseBody()
    JSONObject setadmin(@RequestParam (value = "student_id",defaultValue = "1")int student_id,
                           @RequestParam(value = "course_id",defaultValue = "1")int course_id){

        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);
    }

    //问卷
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/questionnaire")
    @ResponseBody()
    JSONObject questionnaire(@RequestParam (value = "content",defaultValue = "1")String content,
                             @RequestParam(value = "courseinfoid",defaultValue = "1")int course_id){

        teacher_questionnaire teacherQuestionnaire=new teacher_questionnaire();
        teacherQuestionnaire.setContent(content);
        teacherQuestionnaire.setCourseId(course_id);
        teacherQuestionnaire.setTime(new Date());
        teacherquestionnaireService.insert(teacherQuestionnaire);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);
    }
    //评教信息
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/evaluation")
    @ResponseBody()
    JSONObject teachingevaluation( HttpServletRequest request){

        HttpSession session=request.getSession();
        int teacherid= (int) session.getAttribute("id");

        Map<String,Object> msg=new HashMap<>();
        if(teachingEvaluationService.findsatisfaction(teacherid)>0){
            float satisfaction=teachingEvaluationService.findsatisfaction(teacherid);
            if (satisfaction>0.9){
                msg.put("msg","优秀");
            }

            if (satisfaction<0.9&&satisfaction>0.8){
                msg.put("msg","良好");
            }

            if (satisfaction<0.8&&satisfaction>0.6){
                msg.put("msg","合格");
            }
            if (satisfaction<0.6){
                msg.put("msg","一般");
            }

        }  else {
            msg.put("msg","还没有人评教");
        }

        return  JSONObject.fromObject(msg);
    }


}
