package com.IMBA.weui.controller.videocontroller;

import com.IMBA.entity.clock_in;
import com.IMBA.entity.video_series;
import com.IMBA.model.videoRankmodel;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.clock_inService;
import com.IMBA.service.video_recordService;
import com.IMBA.service.video_seriesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.IMBA.weui.controller.videocontroller.VideoOnDemandController.VIDEO_RANK;

@Controller
public class ClockController {
    //打卡状态
    @Autowired
    clock_inService clockInService;
    @Autowired
    video_seriesService videoSeriesService;
    @Autowired
    video_recordService videoRecordService;
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/video/clockstatus")
    @ResponseBody
    JSONObject videoclockstatus(HttpServletRequest request){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        int count=clockInService.selectclockin_today(student_id);
        Map<String,Object> msg=new HashMap<>();
        if (count>0){
            msg.put("msg","no");
        }else {
            msg.put("msg","yes");

        }
        return  JSONObject.fromObject(msg);
    }
    //打卡
    @RequestMapping(value = "/video/clock")
    @ResponseBody
    JSONObject videoclock(HttpServletRequest request){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        int count=clockInService.selectclockin_today(student_id);
        Map<String,Object> msg=new HashMap<>();
        if (count>0){

        }else {
            clock_in record=new clock_in();
            record.setClockedTime(new Date());
            record.setStudentId(student_id);
          clockInService.insert(record);

        }
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);
    }

    @RequestMapping(value = "/video/clocknums")
    @ResponseBody
    JSONObject videoclocknums(HttpServletRequest request){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        int count=clockInService.selectclockin_nums(student_id);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",count);
        return  JSONObject.fromObject(msg);

    }
    //学习完课程，击败列表中的数据
    @RequestMapping(value = "/video/score")
    @ResponseBody
    JSONObject videoscore(HttpServletRequest request){
        HttpSession session=request.getSession();
        int stu_id= (int) session.getAttribute("id");
        String stu="stu_"+stu_id;
        Map<String,Object> msg=new HashMap<>();
        videoRankmodel videorankmodel=new videoRankmodel();
        if (videoRecordService.findvideo_bystu_idandwatch_progress(stu_id,1)>0){


            Set<String>keySet=redisUtil.member(VIDEO_RANK);
            for (String key:keySet){
                if (stu==key){
                    double score=  redisUtil.score(VIDEO_RANK,stu);
                    double rank=redisUtil.reverseRank(VIDEO_RANK,stu)+1;
                    double along=redisUtil.opsForZSetzCard(VIDEO_RANK);
                    System.out.println(along);
                    System.out.println(rank);
                    double winnums=(along-rank)/along;
                    videorankmodel.setWinnum(winnums);
                    videorankmodel.setVideonum(score);
                    msg.put("msg",videorankmodel);
                }
            }

        } else{
            videorankmodel.setWinnum(0);
            videorankmodel.setVideonum(0);
            msg.put("msg",videorankmodel);
        }


        return  JSONObject.fromObject(msg);
    }

 //   收藏课程列表
    @RequestMapping(value = "/video/collectionlist")
    @ResponseBody
    JSONObject collectionlist(HttpServletRequest request,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        PageHelper.startPage(start,rows);
        List<video_series> video_seriesList=videoSeriesService.findvideo_seriesListbycollection_stu_id(student_id);
        PageInfo<video_series> video_seriesPageInfo=new PageInfo<>(video_seriesList);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",video_seriesPageInfo);
        return  JSONObject.fromObject(msg);


    }

    //正在学习的课程
    @RequestMapping(value = "/video/studenting")
    @ResponseBody
    JSONObject studneting(HttpServletRequest request,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        PageHelper.startPage(start,rows);
        List<video_series> video_seriesList=videoSeriesService.findvideo_seriesListbyrecord_stu_id(student_id);
        PageInfo<video_series> video_seriesPageInfo=new PageInfo<>(video_seriesList);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",video_seriesPageInfo);
        return  JSONObject.fromObject(msg);

    }


}
