package com.IMBA.weui.controller.communitycontroller;

import com.IMBA.entity.course_files;
import com.IMBA.entity.download_files;
import com.IMBA.service.course_filesService;
import com.IMBA.service.download_filesService;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//下载
@Controller

public class filedownloadController {


    private String filePath;

    @Value("#{conf.filepath}")
    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }

    @Autowired
    course_filesService courseFilesService;
    @Autowired
    download_filesService downloadFilesService;

    //文件列表
    @RequestMapping(value = "/filedownload/filelist")
    @ResponseBody
    JSONObject filelist(@RequestParam("courseinfoid") int course_id){
        List<course_files>course_filesList=courseFilesService.findbycouser_id(course_id);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",course_filesList);
        return  JSONObject.fromObject(msg);

    }
    //下载

    @RequestMapping(value = "/filedownload/down")
    @ResponseBody
    void filedown(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //下载

        course_files courseFiles=courseFilesService.fingbyid(id);
        if (courseFiles!=null){
            String path =filePath;
            File file = new File(path);
            File[] files = file.listFiles();
            System.out.println("courseFiles.getFilesTitle()"+courseFiles.getFilesTitle());
            //存入下载列表
            HttpSession session=request.getSession();
            int student_id= (int) session.getAttribute("id");//账号

            System.out.println("ddd:"+student_id);
            System.out.println("ddd:"+id);


            download_files record=new download_files();
            record.setDownloadTime(new Date());
            record.setCourseFilesId(id);
            record.setStudentId(student_id);
            downloadFilesService.insert(record);
            response.addHeader("content-disposition", "attachment;filename="+courseFiles.getFilesTitle());
            FileUtils.copyFile(files[0], response.getOutputStream());
        }


    }

}
