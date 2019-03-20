package com.IMBA.weui.controller.videocontroller;

import com.IMBA.entity.*;
import com.IMBA.model.videolistmodel;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//点播
@Controller
public class VideoOnDemandController {

    public static final String VIDEO_RANK = "video_rank";

    @Autowired
    RedisUtil redisUtil;
    private String videofilepath;

    @Value("#{conf.videofilepath}")
    public void setFilePath(String videofilepath) {
        System.out.println(videofilepath);
        this.videofilepath = videofilepath;
    }
    @Autowired
    video_seriesService videoSeriesService;
    @Autowired
    videoService videoservice;
    @Autowired
    video_collectionsService videoCollectionsService;
    @Autowired
    video_recordService videoRecordService;
    @Autowired
    video_series_likeService videoSeriesLikeService;
    //视频是否收藏
//    @RequiresRoles("teacher")
    @RequestMapping(value = "/videoseries/iscollection")
    @ResponseBody
    JSONObject videoseriesidcollection(@RequestParam(name = "video_series_id")int video_series_id,HttpServletRequest request){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        int count=videoCollectionsService.findcollectionsbystu_idandvideo_series_id(student_id,video_series_id);
        Map<String,Object> msg=new HashMap<>();
        if (count>0){
            msg.put("msg","yes");
        }else {
            msg.put("msg","no");
        }

        return  JSONObject.fromObject(msg);


    }

    //视频收藏
//    @RequiresRoles("teacher")
    @RequestMapping(value = "/videoseries/collection")
    @ResponseBody
    JSONObject videoseriescollection(@RequestParam(name = "video_series_id")int video_series_id,HttpServletRequest request){

        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        video_collections videoCollections=new video_collections();
        videoCollections.setCollectionTime(new Date());
        videoCollections.setStudentId(student_id);
        videoCollections.setVideoSeriesId(video_series_id);
        videoCollectionsService.insert(videoCollections);

        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);
    }
    //上传视频
    //文件上传
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/videoseries/add")
    @ResponseBody
    JSONObject videoseries( @RequestParam(value = "course_lecturer",defaultValue = "白老师") String course_lecturer,
                        @RequestParam(value = "course_title",defaultValue = "数学课") String course_title,
                        @RequestParam(value = "course_type",defaultValue = "教育") String course_type,
                        HttpServletRequest request) throws IOException {


        video_series videoSeries=new video_series();
        videoSeries.setCourseLecturer(course_lecturer);
        videoSeries.setCourseTitle(course_title);
        videoSeries.setCourseType(course_type);
        videoSeries.setWatchingNum(0);
        int id= videoSeriesService.insert(videoSeries);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",id);
        return  JSONObject.fromObject(msg);

        //存入数据库

    }


    //添加视频
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/video/add",produces="text/html;charset=utf-8")
    @ResponseBody
    JSONObject videoseries(@RequestParam("file") CommonsMultipartFile partFile,@RequestParam(name = "video_series_id")int video_series_id ,@RequestParam(name = "video_title")String video_title, HttpServletRequest request ) throws IOException {
        HttpSession session=request.getSession();
        int Uploaderid= (int) session.getAttribute("id");
        String path= videofilepath;
        String filename=partFile.getOriginalFilename();//上传时候的文件名
        File file = new File(path+"/"+filename);
        InputStream inputStream = partFile.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream, file);
        String filepath=path+"/"+filename;
        video v=new video();
        v.setVideoSeriesId(video_series_id);
        v.setVideoPath(filepath);
        v.setVideoTitle(video_title);
        videoservice.insert(v);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","sussess");
        return  JSONObject.fromObject(msg);

    }
    //上传封面

    //视频选择列表
//    @RequiresRoles("teacher")

    @RequestMapping(value = "/teacher/videoseries/list")
    @ResponseBody
    JSONObject videoserieslist(@RequestParam(name = "course_type",defaultValue = "教育")String course_type,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows){
        PageHelper.startPage(start,rows);
        List<video_series>video_seriesList=videoSeriesService.findvideo_seriesList(course_type);
        PageInfo<video_series>video_seriesPageInfo=new PageInfo<>(video_seriesList);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",video_seriesPageInfo);
        return  JSONObject.fromObject(msg);
    }

    //视频内容页列表
//    @RequiresRoles("teacher")
    @RequestMapping(value = "/video/list")
    @ResponseBody
    JSONObject videolist(@RequestParam(name = "video_series_id",defaultValue = "1")int video_series_id){
        List<videolistmodel>videolistmodels=videoSeriesService.findvideoList(video_series_id);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",videolistmodels);
        return  JSONObject.fromObject(msg);
    }
    //观看视频
    @RequestMapping(value = "/video/id")
    @ResponseBody
    JSONObject video_id(@RequestParam(name = "video_id",defaultValue = "1")int video_id,@RequestParam(name="video_series_id",defaultValue = "1")int video_series_id){
        //正在观看功能实现
        String video=videoservice.findvideo(video_id);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",video);
        //记录
        videoSeriesService.updatewathing_num(video_series_id);
        return  JSONObject.fromObject(msg);
    }
    //视频进度更新
    @RequestMapping(value = "/video/record")
    @ResponseBody
    JSONObject videorecord(@RequestParam(name = "video_id",defaultValue = "1")int video_id,@RequestParam(name = "watch_progress",defaultValue = "1")float watch_progress, HttpServletRequest request){
        HttpSession session=request.getSession();
        int stu_id= (int) session.getAttribute("id");
        //查找是否存在
        video_record videoRecord=new video_record();
        videoRecord.setStudentId(stu_id);
        videoRecord.setVideoId(video_id);
        videoRecord.setWatchProgress(watch_progress);
        if (watch_progress==1){
            if (videoRecordService.findvideo_recordbystu_idandvideo_idandwatch_progress(stu_id,video_id,watch_progress)<=0){
                //已经存在为1的
                //更新排名
                String stu="stu_"+stu_id;
                redisUtil.incrementScore(VIDEO_RANK ,stu,1);
            }

        }
        if (videoRecordService.findvideo_recordbystu_idandvideo_id(stu_id,video_id)>0){
            //更新

            videoRecordService.updatewatch_progressbystu_idandvideo_id(videoRecord);

        }else {

            videoRecordService.insert(videoRecord);
        }
        Map<String,Object> msg=new HashMap<>();

        return  JSONObject.fromObject(msg);
    }


    //点赞数
    @RequestMapping(value = "/video/likenum")
    @ResponseBody
    JSONObject videolikenum(@RequestParam(name = "video_series_id",defaultValue = "1")int video_series_id){

        int count=videoSeriesLikeService.findcoutbyvideo_series_id(video_series_id);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",count);

        return  JSONObject.fromObject(msg);
    }
    //是否可以点赞
    @RequestMapping(value = "/video/islike")
    @ResponseBody
    JSONObject videoislike(@RequestParam(name = "video_series_id",defaultValue = "1")int video_series_id,HttpServletRequest request){
        HttpSession session=request.getSession();
        int stu_id= (int) session.getAttribute("id");
        int count=videoSeriesLikeService.findlikesbystu_idandvideo_series_id(stu_id,  video_series_id);
        Map<String,Object> msg=new HashMap<>();
        if (count>0){
            msg.put("msg","no");
        }else {
            msg.put("msg","yes");
        }


        return  JSONObject.fromObject(msg);
    }
    //点赞
    @RequestMapping(value = "/video/likeadd")
    @ResponseBody
    JSONObject likeadd(@RequestParam(name = "video_series_id",defaultValue = "1")int video_series_id,HttpServletRequest request){
        HttpSession session=request.getSession();
        int stu_id= (int) session.getAttribute("id");
        video_series_like videoSeriesLike=new video_series_like();
        videoSeriesLike.setStuId(stu_id);
        videoSeriesLike.setVideoSeries(video_series_id);
        int count=videoSeriesLikeService.insert(videoSeriesLike);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);
    }







}
