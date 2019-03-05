package com.IMBA.weui.controller.videocontroller;

import com.IMBA.entity.course_files;
import com.IMBA.entity.register;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
    //上传视频
    //文件上传
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/videoseries",produces="text/html;charset=utf-8")
    @ResponseBody
    JSONObject videoseries(@RequestParam("file") CommonsMultipartFile partFile, @RequestParam("course_lecturer") String course_lecturer,
                        @RequestParam("course_title") String course_title,
                        @RequestParam("course_type") String course_type,
                        HttpServletRequest request) throws IOException {


        HttpSession session=request.getSession();
        int Uploaderid= (int) session.getAttribute("id");

        String path= videofilepath;
        String filename=partFile.getOriginalFilename();//上传时候的文件名

        File file = new File(path+"/"+filename);
        InputStream inputStream = partFile.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream, file);
        String filepath=path+"/"+filename;









        Map<String,Object> msg=new HashMap<>();

        msg.put("msg","success");
        return  JSONObject.fromObject(msg);

        //存入数据库

    }
    //视频选择列表
    //视频内容页列表
    //视频收藏
    //视频记录



}
