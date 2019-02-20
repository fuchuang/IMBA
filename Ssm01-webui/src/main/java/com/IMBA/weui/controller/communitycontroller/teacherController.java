package com.IMBA.weui.controller.communitycontroller;

import com.IMBA.entity.course_files;
import com.IMBA.service.course_filesService;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.ehcache.util.TimeUtil;
import net.sf.json.JSONArray;
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
import java.util.Map;

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

    //文件上传
    @RequiresRoles("teacher")
    @RequestMapping(value = "/teacher/filesend",produces="text/html;charset=utf-8")
    @ResponseBody
    JSONObject filesend(@RequestParam("file") CommonsMultipartFile partFile, @RequestParam("course_id") int course_id, HttpServletRequest request) throws IOException {


        HttpSession session=request.getSession();
        int Uploaderid= (int) session.getAttribute("id");

        String path=filePath;
//        String name = request.getParameter("name");

//        String id=request.getParameter("course_id");

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
    //点名列表
    //点名

}
