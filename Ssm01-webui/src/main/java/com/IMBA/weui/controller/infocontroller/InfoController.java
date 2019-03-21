package com.IMBA.weui.controller.infocontroller;

import com.IMBA.dto.teachInfoDto;
import com.IMBA.entity.match;
import com.IMBA.entity.notification;
import com.IMBA.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Info/")
public class InfoController extends BaseController {
    /**
     * 通知详情
     */
    @GetMapping("notificationDetail")
    @ResponseBody
    public R notificationDetail(@RequestParam(value = "stuId") int stuId,
                                @RequestParam(value = "notificationId") int notificationId){
        notification n=notifiService.noticesDetail(stuId,notificationId);
        if (n!=null){
            return reToObj(n);
        }else {
            return error();
        }
    }


    /**
     * 通知列表
     */
    @GetMapping("notificationList")
    @ResponseBody
    public R showNotifications(@RequestParam(value = "stuId")int stuId,
                               @RequestParam(value = "offset")int offset,
                               @RequestParam(value = "limit")int limit){
        List list= notifiService.findNoticesByStuId(stuId,offset,limit);
        Map result=new HashMap();
        result.put("data",list);
        result.put("count",notifiService.getNoticesCount(stuId));
        return reToObj(result);
    }

    /**
     * 成绩查询
     * @return 1.所有课程绩点 2，某学期平均绩点 3.某学期绩点排名 4.综合测评 5.课程成绩
     */
    @GetMapping("scoreInquiry")
    @ResponseBody
    public R scoreInquiry(@RequestParam(value = "stuId")int stuId,
                          @RequestParam(value = "year")String year){
        float averageGPA=scoreservice.getAverageGPA(stuId);
        float semesterGPA=scoreservice.getGPAByTerm(stuId,year);
        int rank=scoreservice.getRankInMajor(stuId,year);
        List courseScore=scoreservice.getScoresByTerm(stuId,year);
        if (averageGPA==-1||semesterGPA==-1)return error();
        Map map=new HashMap();
        map.put("averageGPA",averageGPA);
        map.put("semesterGPA",semesterGPA);
        map.put("rank",rank);
        map.put("courseScore",courseScore);
        return reToObj(map);
    }

    /**
     * 教师信息列表
     */
    @GetMapping("teachersInfo")
    @ResponseBody
    public R teachersInfo(@RequestParam(value = "stuId")int stuId){
        List<teachInfoDto> result=teacherservice.getTeachersInfo(stuId);
        return reToObj(result);
    }
    /**
     * 选课
     * @param electiveType 选课类型
     * @param stuId
     */
    @GetMapping("electiveInfo")
    @ResponseBody
    public R electiveInfo(@RequestParam(value = "stuId")int stuId,
                          @RequestParam(value = "electiveType")String electiveType){
        if (electiveType.equals("人文社科") || electiveType.equals("自然科学")||electiveType.equals("创新创业")){
            List list=electiveservice.findElectiveByType(stuId,electiveType);
            return reToObj(list);
        }else {
            return error("类型错误");
        }

    }

    /**
     * 选课评论信息
     * @param electiveId 具体某一选课的id
     */
    @GetMapping("electiveDetailInfo")
    @ResponseBody
    public R electiveDetailInfo(@RequestParam(value = "electiveId")int electiveId){
        List result=electiveCommentsService.getComments(electiveId);
        return reToObj(result);
    }
//
    /**
     * 某一类比赛列表
     * @param offset 数据偏移量
     * @param dataNum 请求的数据条数
     * @return count 为数据库中记录总量
     */
    @GetMapping("matchInfo")
    @ResponseBody
    public R matchInfo(@RequestParam(value = "matchType")int matchType,
                       @RequestParam(value = "offset") int offset,
                       @RequestParam(value = "dataNum")int dataNum){
        List<match> result=matchservice.getMatchByType(matchType,offset,dataNum);
        int count=matchservice.getCount(matchType);
        Map res=new HashMap();
        res.put("data",result);
        res.put("count",count);
        return success(res);
    }
//
    /**
     * 比赛详情
     */
    @GetMapping("matchDetailInfo")
    @ResponseBody
    public R matchDetailInfo(@RequestParam(value = "matchId")int matchId){
        match result=matchservice.getMatchDetail(matchId);
        if (result!=null){
            return  reToObj(result);
        }else {
            return error();
        }
    }

    /**
     * 添加选课评论
     *
     */
    @GetMapping("ElectiveComment")
    @ResponseBody
    public R addElectiveComment(@RequestParam(value = "stuId")int stuId,
                                @RequestParam(value = "electiveId")int electiveId,
                                @RequestParam(value = "content")String content,
                                @RequestParam(value = "date")Date date){
        boolean result=electiveCommentsService.addComment(stuId,electiveId,date,content);
        if (result){
            return success("添加成功");
        }else{
            return error("添加失败");
        }
    }

    /**
     * 考试详情
     */
    @GetMapping("examInfo")
    @ResponseBody
    public R examInfo(@RequestParam(value = "stuId")int stuId){
        List result=examinationservice.getExams(stuId);
        return reToObj(result);
    }

    /**
     * 把考试标记到课表
     * @return stuExamCourseId 用于取消标记到课表
     */
    @GetMapping("addExamToSchedule")
    @ResponseBody
    public R addExamToSchedule(@RequestParam(value = "stuId")int stuId,
                               @RequestParam(value = "examId")int examId,
                               @RequestParam(value = "stuExamId")int stuExamId){
       int stuExamCourseId=examinationservice.addToSchedule(stuId,examId,stuExamId);
       return success("stuExamCourseId",stuExamCourseId);

    }

    /**
     * 取消标记到课表
     * @param stuExamCourseId 成功标记后返回的courseId
     * @param stuExamId 学生对应考试的id
     */
    @GetMapping("cancelMarkAtSchedule")
    @ResponseBody
    public R cancelMarkAtSchedule(@RequestParam(value = "stuExamId")int stuExamId,
                                  @RequestParam(value = "stuExamCourseId")int stuExamCourseId ){
        examinationservice.cancelAddToSchedule(stuExamId,stuExamCourseId);
        return success();
    }

    /**
     * 选课宝典搜索
     */
    @GetMapping("searchForElective")
    @ResponseBody
    public R searchForElective(@RequestParam(value = "stuId")int stuId,
                               @RequestParam(value = "keyWords")String keyWords){
        List result;
        if (keyWords.trim().equals("")){
            return error();
        }else {
            result=electiveservice.searchByKeyWord(stuId,keyWords);
        }
        return reToObj(result);
    }

    /**
     * 收藏选修
     * @param status 收藏状态 1收藏 0取消收藏
     * @param time 收藏时间
     */
    @GetMapping("collectElective")
    @ResponseBody
    public R collectElective(@RequestParam(value = "stuId")int stuId,
                             @RequestParam(value = "electiveId")int electiveId,
                             @RequestParam(value = "status")int status,
                             @RequestParam(value = "time")Date time){
        boolean result;
        switch (status){
            case 0:
                result=electiveservice.cancelCollect(stuId,electiveId);
                break;
            case 1:
                result=electiveservice.addCollect(stuId,electiveId,time);
                break;
            default:return error();
        }
        if (result)return success();
        return error();
    }

    /**
     * 点赞选修
     * @param status 点赞状态 1为点赞 0为取消点赞
     *
     */
    @GetMapping("likeElective")
    @ResponseBody
    public R likeElective(@RequestParam(value = "stuId")int stuId,
                          @RequestParam(value = "electiveId")int electiveId,
                          @RequestParam(value = "status")int status){
        boolean result;
        switch (status){
            case 0:
                result=electiveservice.cancelLike(stuId,electiveId);
                break;
            case 1:
                result=electiveservice.addLike(stuId,electiveId);
                break;
            default:return error();
        }
        if (result)return success();
        return error();
    }

    /**
     * 点赞或取消点赞教师
     */
    @GetMapping("likeTeacher")
    @ResponseBody
    public R likeTeacher(@RequestParam(value = "stuId")int stuId,
                         @RequestParam(value = "teacherId")int teacherId,
                         @RequestParam(value = "status")int status){
        boolean result;
        switch (status){
            case 1:
                result=teacherservice.addLikes(stuId,teacherId);
                break;
            case 0:
                result=teacherservice.cancelLikes(stuId,teacherId);
                break;
            default:return error();
        }
        if (result)return success();
        return error();
    }

    /**
     *学生评教老师
     */
    @GetMapping("teachingEvaluation")
    @ResponseBody
    public R teachingEvaluation(@RequestParam(value = "stuId")int stuId,
                                @RequestParam(value = "teacherId")int teacherId,
                                @RequestParam(value = "grade")float grade){
        boolean result=teacherservice.evaluteTeacher(stuId,teacherId,grade);
        if (result)return success("添加成功");
        return error();
    }



}





























