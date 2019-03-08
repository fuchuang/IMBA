package com.IMBA.weui.controller.videocontroller;

import com.IMBA.entity.*;
import com.IMBA.model.videolistmodel;
import com.IMBA.service.videoService;
import com.IMBA.service.video_collectionsService;
import com.IMBA.service.video_seriesService;
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
        videoSeriesService.insert(videoSeries);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);

        //存入数据库

    }
    //视频列表

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
        //视频截图

        videoservice.insert(v);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","sussess");
        return  JSONObject.fromObject(msg);


    }
    //视频选择列表
//    @RequiresRoles("teacher")
//    @RequestMapping(value = "/teacher/videoseries/list")
//    @ResponseBody
//    JSONObject videoserieslist(){
//
//    }

    //视频内容页列表
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/video/list")
    @ResponseBody
    JSONObject videolist(@RequestParam(name = "video_series_id")int video_series_id){

        List<videolistmodel>videolistmodels=videoSeriesService.findvideoList(video_series_id);

        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",videolistmodels);
        return  JSONObject.fromObject(msg);
    }
    //视频是否收藏
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/videoseries/iscollection")
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
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/videoseries/collection")
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
    //视频记录



}
