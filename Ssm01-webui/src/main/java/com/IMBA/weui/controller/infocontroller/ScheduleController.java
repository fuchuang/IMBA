package com.IMBA.weui.controller.infocontroller;

import com.IMBA.entity.*;
import com.IMBA.utils.QRCodeUtil;
import com.IMBA.utils.R;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/schedule/")
public class ScheduleController extends BaseController{

    private String filePath;

    @Value("#{conf.filepath}")

    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }

    /**
        请求一周的课程表
     */
    @GetMapping("showWeekSchedule")
    @ResponseBody
    public R showWeekSchedule(@RequestParam(name = "stuId",defaultValue = "1") int stuId,@RequestParam(name = "year",defaultValue = "2018年") String year, @RequestParam(name = "week",defaultValue = "1")int week){
        if(stuId<0 || year.equals("") || week<0 ){
            return error("参数不正确");
        }else {
            List<course> list=stuCourseService.findCoursesOfWeek(stuId,year, (byte) week);
            return reToObj(list);
        }
    }

    /**
     * 请求一天的课程表
     */
    @GetMapping("showDaySchedule")
    @ResponseBody
    public R showDaySchedule(@RequestParam(name = "stuId",defaultValue = "1")int stuId, @RequestParam(name = "year",defaultValue = "2018年")String year,@RequestParam(name = "week",defaultValue = "1") int week,  @RequestParam(name = "day",defaultValue = "1")int day){
        if(stuId<0 || year.equals("") || week<0  || day<0 || day>=7){
            return error("参数不正确");
        }else {
            List<course> list=stuCourseService.findCoursesOfDay(stuId,year,(byte)week,(byte)day);
            return reToObj(list);
        }
    }

    /**
        添加课程
     */
    @PostMapping("addSchedule")
    @ResponseBody
    public R addSchedule(@RequestBody course course,
                         @RequestParam(value = "stuId") int stuId){
        int courseId=courseservice.addCourse(course);
        int n=stuCourseService.addStuCourse(stuId,courseId);
        if (n!=-1){
            return success();
        }else {
            return error();
        }
    }

    /**
     * 添加弹幕
     */
    @PostMapping("addBulletComments")
    @ResponseBody
    public R addBulletComments(@RequestBody bullet_comments bulletComments ){
        int n=bulletCommentsService.addBulletComments(bulletComments);
        if(n>0){
            return success();
        }else {
            return error();
        }
    }
    /**
     * 请求一周的弹幕
     */
    @GetMapping("bulletCommentsInWeek")
    @ResponseBody
    public R bulletCommentsInWeek(@RequestParam(name = "majorId",defaultValue = "1") int majorId,
                                  @RequestParam(name = "year",defaultValue = "2019年上半学期")  String year,
                                  @RequestParam(name = "week",defaultValue = "1")  int week){
        List<String> list=bulletCommentsService.showWeekComments(majorId,year,week);
        return reToObj(list);
    }

    /**
     * 添加备忘录
     * 请求课表的时候返回每个课程的id
     */
    @RequestMapping("addMemo")
    @ResponseBody
    public R addMemo(@RequestParam(value = "stuId",defaultValue = "1") int stuId,
                     @RequestParam(value = "courseId",defaultValue = "1")int courseId,
                     @RequestParam(value = "content",defaultValue = "学习") String content){
        int id=memoservice.addMemo(stuId,courseId,content);
        return reToObj(id);
    }
    /**
     * 修改备忘录
     */
    @RequestMapping("editMemo")
    @ResponseBody
    public R editMemo(@RequestParam(value = "memoId",defaultValue = "1")int memoId,
                      @RequestParam(value = "content",defaultValue = "学习") String content){
        int n=memoservice.editMemo(memoId,content);
        if (n>0){
            return success();
        }else {
            return error();
        }
    }

    /**
     * 删除备忘录
     */
    @RequestMapping("deleteMemo")
    @ResponseBody
    public R deleteMemo(@RequestParam(value = "memoId",defaultValue = "1")int memoId){
        int n=memoservice.deleteMemo(memoId);
        if (n>0){
            return success();
        }else {
            return error();
        }
    }

    /**
     * 请求一周备忘录
     */
    @RequestMapping("showMemoInWeek")
    @ResponseBody
    public R showMemoInWeek(@RequestParam(value="stuId",defaultValue = "1")int stuId,
                            @RequestParam(value = "year",defaultValue = "1")String year,
                            @RequestParam(value = "week",defaultValue = "1") int week){
        List<course> courses=stuCourseService.findCoursesOfWeek(stuId,year, (byte) week);
        List<memo> memos=memoservice.showMemoInWeek(stuId,courses);
        return reToObj(memos);
    }

    /**
     * 显示课程具体信息
     */
    @RequestMapping("showCourseDetail")
    @ResponseBody
    public R showCourseDetail(@RequestParam(value="courseId",defaultValue = "1")int courseId){
        course c=courseservice.findCourseById(courseId);
        return reToObj(c);
    }
//
    /**
     * 上传背景图
     */
    @RequestMapping("uploadBgImg")
    @ResponseBody
    public R uploadBgImg(HttpServletResponse response,
                         @RequestParam(value = "stuId",defaultValue = "1") int stuId,
                         @RequestParam(value = "file",defaultValue = "1") MultipartFile file){
        response.setContentType("multipart/form-data");
        try {
            if(!file.isEmpty()){
                String fpath=filePath;
                schedule_background bg=new schedule_background();
                String filename= UUID.randomUUID().toString();
                String ext= FilenameUtils.getExtension(file.getOriginalFilename());
                file.transferTo(new File(fpath +"/upload/"+filename+"."+ext));
                bg.setImgPath("/upload/"+filename+"."+ext);
                bg.setStudentId(stuId);
                String path= backgroundService.saveBgImg(bg, stuId,fpath);
                if(!path.isEmpty()){
                    backgroundService.writeToStream(response.getOutputStream(),fpath+bg.getImgPath());
                    return success();
                }
            }
            return error();
        }catch (Exception e){
            return error(e.getMessage());
        }

    }

    /**
     * 请求背景图
     */

    @RequestMapping("showBgImg")
    @ResponseBody
    public R showBgImg(HttpServletResponse response,@RequestParam(value="stuId",defaultValue = "1")int stuId){
        String path=backgroundService.findImgByStuId(stuId);
        if (path!=null){
            try {
                backgroundService.writeToStream(response.getOutputStream(),filePath+path);
                return success();
            } catch (IOException e) {
                return error(e.getMessage());
            }
        }else {
            return error();
        }
    }

/**
     * 生成课表二维码 写入response中
     */
    @RequestMapping("qrcode")
    @ResponseBody
    public void qrcode(HttpServletResponse response,
                       @RequestParam(value = "stuId",defaultValue = "1") int stuId,
                       @RequestParam(value = "year",defaultValue = "2019年上半学期")String year){
        ServletOutputStream servletOutputStream=null;
        try {
            servletOutputStream=response.getOutputStream();
            QRCodeUtil.writeToStream("year:"+year+"，stuId:"+stuId,servletOutputStream);
            response.setContentType("image/png");
            System.out.println(response+"response");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(servletOutputStream!=null){
                try {
                    servletOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 每日一词
     */
    @RequestMapping("getSentence")
    @ResponseBody
    public R getSentence() {
        Sentence result=sentenceservice.getSentence();
        if (result!=null)return reToObj(result);
        return error();
    }

    /**
     * 获取一个学期的课程
     */

    @RequestMapping("getCoursesOfSemester")
    @ResponseBody
    public R getCoursesOfSemester(@RequestParam(value="stuId",defaultValue = "1")int stuId, @RequestParam(value="year",defaultValue = "2018年")String year){
        List result=stuCourseService.findCourseOfSemester(stuId,year);
        return reToObj(result);
    }



}
