package com.IMBA.weui.controller.infocontroller;

import com.IMBA.dto.electiveResultDto;
import com.IMBA.dto.studentInfo;
import com.IMBA.entity.major;
import com.IMBA.entity.posts;
import com.IMBA.entity.student;
import com.IMBA.entity.video_series;
import com.IMBA.service.majorService;
import com.IMBA.utils.DownloadFile;
import com.IMBA.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/Profile/")
@RequestMapping("/Profile/")
public class ProfileController extends BaseController {
    private String filePath;

    @Value("#{conf.filepath}")

    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }


    @Autowired
    majorService majorservice;
    /**
     * 个人信息
     */
    @GetMapping("personalInfo")
    @ResponseBody
    public R personalInfo(@RequestParam(value="stuId")int stuId){
        student s= studentservice.findbystuid( stuId);
        if (s==null)return null;
        major m= majorservice.findById(s.getMajorId());
        studentInfo info=new studentInfo();
        info.setInfo(s,m);

        if (info!=null)return reToObj(info);
        return error();
    }

    /**
     *修改个性签名
     */
    @GetMapping("editSignature")
    @ResponseBody
    public R editSignature(@RequestParam(value="stuId",defaultValue = "1")int stuId, @RequestParam(value="content",defaultValue = "content")String content){
        boolean n=studentservice.updateSignature(stuId,content);
        if (n){
            return success();
        }else {
            return error();
        }
    }

    /**
     * 通知收藏列表
     */
    @GetMapping("notificationCollection")
    @ResponseBody
    public R notificationCollection(@RequestParam(value="stuId",defaultValue = "1")int stuId,
                                    @RequestParam(value="offset",defaultValue = "6")int offset,
                                    @RequestParam(value="limit",defaultValue = "0")int limit){
        List list=notifiService.findCollectionsByStuId(stuId,offset,limit);
        Map result=new HashMap();
        result.put("data",list);
        result.put("count",notifiService.getCollectionCount(stuId));
        return success(result);
    }

    /**
     * 收藏通知
     */
    @GetMapping("collectNotification")
    @ResponseBody
    public R collectNotification(@RequestParam(value="stuId",defaultValue = "1")int stuId, @RequestParam(value="noticeId",defaultValue = "1")int noticeId){
        boolean ans=stuNotificationService.addItem(stuId,noticeId);
        if (ans){
            return success();
        }else {
            return error();
        }
    }

    /**
     * 视频收藏列表
     */
    @GetMapping("videoCollection")
    @ResponseBody
    public R videoCollection(@RequestParam(value="stuId",defaultValue = "1")int stuId){
        List<video_series> list=videoSeriesService.findCollectionsByStuId(stuId);
        return reToObj(list);
    }

    /**
     * 选课收藏列表
     */
    @GetMapping("electiveCollection")
    @ResponseBody
    public R electiveCollection(@RequestParam(value="stuId",defaultValue = "1")int stuId){
        List<electiveResultDto> list=electiveservice.findCollectionsByStuId(stuId);
        return reToObj(list);
    }

    /**
     * 通知浏览记录?????
     */
    @GetMapping("viewRecentlyNotice")
    @ResponseBody
    public R viewRecentlyNotice(@RequestParam(value="stuId",defaultValue = "1")int stuId,
                                @RequestParam(value="offset",defaultValue = "6")int offset,
                                @RequestParam(value="limit",defaultValue = "0")int limit){
        List list=notifiService.getViewRecently(stuId,offset,limit);
        Map result=new HashMap();
        result.put("data",list);
        result.put("count",notifiService.getViewRecentlyCount(stuId));
        return success(result);
    }


    /**
     * 视频浏览记录
     */
    @GetMapping("videoViewedHistory")
    @ResponseBody
    public R videoViewedHistory(@RequestParam(value="stuId",defaultValue = "1")int stuId){
        List list=videoSeriesService.watchedRecentlyByStuId(stuId);
        return reToObj(list);
    }


    /**
     * 已看帖子列表
     */
    @GetMapping("/myPosts/viewdRecently")
    @ResponseBody
    public R viewdRecently(@RequestParam(value="stuId",defaultValue = "1")int stuId){
       List<posts> list= postsservice.getViewedRecently(stuId);
       return reToObj(list);
    }

    /**
     * 已发帖子列表
     */
    @GetMapping("/myPosts/posted")
    @ResponseBody
    public R postedList(@RequestParam(value="stuId",defaultValue = "1")int stuId){
        List<posts> list= postsservice.getViewedRecently(stuId);
        return reToObj(list);
    }

    /**
     * 点赞的帖子列表
     */
    @GetMapping("/myPosts/likes")
    @ResponseBody
    public R LikedPosts(@RequestParam(value="stuId",defaultValue = "1")int stuId){
        List<posts> list= postsservice.getLikedPosts(stuId);
        return reToObj(list);
    }

    /**
     * 下载附件
     * @param filePath 文件路径
     */
    @GetMapping("downloadFile")
    @ResponseBody
    public void downloadFile(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam(value="filePath")  String filePath){
        String fileName=filePath+filePath;
        DownloadFile.download(response,fileName);
    }

    /**
     * 个人考勤表
     * @param stuId 学生id
     * @param year 学年 eg:2019年上半学期
     *
     *             ？？？？？
     */
    @GetMapping("attendanceRecord")
    @ResponseBody
    public R attendanceRecord(@RequestParam(value="stuId",defaultValue = "1")int stuId,
                              @RequestParam(value="year",defaultValue = "2018年")String year){
        Map map=clockInService.getAttendanceRecord(stuId,year);
        return reToObj(map);
    }

}
