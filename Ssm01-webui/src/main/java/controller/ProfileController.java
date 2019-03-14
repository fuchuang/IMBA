package controller;

import com.IMBA.dto.electiveResultDto;
import com.IMBA.dto.studentInfo;
import com.IMBA.entity.elective;
import com.IMBA.entity.posts;
import com.IMBA.entity.video_series;
import com.IMBA.utils.DownloadFile;
import com.IMBA.utils.R;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/Profile/")
public class ProfileController extends BaseController {

    /**
     * 个人信息
     */
    @GetMapping("personalInfo")
    @ResponseBody
    public R personalInfo(@RequestParam(value="stuId")int stuId){
        studentInfo result=studentservice.getStuInfoById(stuId);
        if (result!=null)return reToObj(result);
        return error();
    }

    /**
     *修改个性签名
     */
    @PostMapping("editSignature")
    @ResponseBody
    public R  editSignature(@RequestParam(value="stuId")int stuId,@RequestParam(value="content")String content){
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
    public R notificationCollection(@RequestParam(value="stuId")int stuId,
                                    @RequestParam(value="offset")int offset,
                                    @RequestParam(value="limit")int limit){
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
    public R collectNotification(@RequestParam(value="stuId")int stuId,@RequestParam(value="noticeId")int noticeId){
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
    public R videoCollection(@RequestParam(value="stuId")int stuId){
        List<video_series> list=videoSeriesService.findCollectionsByStuId(stuId);
        return reToObj(list);
    }

    /**
     * 选课收藏列表
     */
    @GetMapping("electiveCollection")
    @ResponseBody
    public R electiveCollection(@RequestParam(value="stuId")int stuId){
        List<electiveResultDto> list=electiveservice.findCollectionsByStuId(stuId);
        return reToObj(list);
    }

    /**
     * 通知浏览记录
     */
    @GetMapping
    @ResponseBody
    public R viewRecentlyNotice(@RequestParam(value="stuId")int stuId,
                                @RequestParam(value="offset")int offset,
                                @RequestParam(value="limit")int limit){
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
    public R videoViewedHistory(@RequestParam(value="stuId")int stuId){
        List list=videoSeriesService.watchedRecentlyByStuId(stuId);
        return reToObj(list);
    }


    /**
     * 已看帖子列表
     */
    @GetMapping("/myPosts/viewdRecently")
    @ResponseBody
    public R viewdRecently(@RequestParam(value="stuId")int stuId){
       List<posts> list= postsservice.getViewedRecently(stuId);
       return reToObj(list);
    }

    /**
     * 已发帖子列表
     */
    @GetMapping("/myPosts/posted")
    @ResponseBody
    public R postedList(@RequestParam(value="stuId")int stuId){
        List<posts> list= postsservice.getViewedRecently(stuId);
        return reToObj(list);
    }

    /**
     * 点赞的帖子列表
     */
    @GetMapping("/myPosts/likes")
    @ResponseBody
    public R LikedPosts(@RequestParam(value="stuId")int stuId){
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
        String fileName=request.getSession().getServletContext().getRealPath("/")+filePath;
        DownloadFile.download(response,fileName);
    }

    /**
     * 个人考勤表
     * @param stuId 学生id
     * @param year 学年 eg:2019年上半学期
     */
    @GetMapping("attendanceRecord")
    @ResponseBody
    public R attendanceRecord(@RequestParam(value="stuId")int stuId,
                              @RequestParam(value="year")String year){
        Map map=clockInService.getAttendanceRecord(stuId,year);
        return reToObj(map);
    }

}
