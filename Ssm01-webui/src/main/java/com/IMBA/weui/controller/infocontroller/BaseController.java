package com.IMBA.weui.controller.infocontroller;

import com.IMBA.service.*;
import com.IMBA.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class BaseController {
    //课程表
//    @Autowired
//    ScheduleService scheduleService;


    @Autowired
    registerService registerservice;

    //学生
    @Autowired
    studentService studentservice;

    //课程
    @Autowired
    courseService courseservice;

    @Autowired
    //弹幕
            bullet_commentsService bulletCommentsService;

    @Autowired
    //课程备忘录
            memoService memoservice;

    //课表背景图
    @Autowired
    BackgroundService backgroundService;

    //学生-课程
    @Autowired
    stu_courseService stuCourseService;

    //通知
    @Autowired
    notificationService notifiService;

    //视频
    @Autowired
    videoService videoservice;

    //视频系列
    @Autowired
    video_seriesService videoSeriesService;

    //选课
    @Autowired
    electiveService electiveservice;

    //学生-通知
    @Autowired
    stu_notificationService stuNotificationService;

    //帖子
    @Autowired
    postsService postsservice;

    //签到考勤
    @Autowired
    clock_inService clockInService;

    //教师
    @Autowired
    teacherService teacherservice;

    //比赛
    @Autowired
    matchService matchservice;

    //选修评论
    @Autowired
    elective_commentsService electiveCommentsService;

    //考试
    @Autowired
    examinationService examinationservice;

    //成绩
    @Autowired
    scoreService scoreservice;

    //每日一句
    @Autowired
    sentenceService sentenceservice;





    /**
     * 响应返回结果
     *
     */
    /**
     * 返回成功
     */
    public R success(){return R.ok();}

    /**
     * 返回成功消息
     */
    public R success(String message){return R.ok(message);}
    public R success(Map<String,Object> map){return R.ok(map);}
    public R success(String message, Object data){return R.ok(message,data);}

    /**
     * 返回失败
     */

    public R error(){return R.error();}

    /**
     * f返回失败消息
     */

    public R error(String message){return R.error(message);}

    /**
     * 返回object
     */
    public R reToObj(Object obj){return R.ok(obj);}



}
