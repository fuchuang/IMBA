package controller;
import com.IMBA.entity.Sentence;
import com.IMBA.entity.course;
import com.IMBA.entity.memo;
import com.IMBA.utils.JsonUtil;
import com.IMBA.utils.QRCodeUtil;
import com.IMBA.utils.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.IMBA.entity.bullet_comments;


@Controller
@RequestMapping("/schedule/")
public class ScheduleController extends BaseController{
    /**
        请求一周的课程表
     */
    @GetMapping("showWeekSchedule")
    @ResponseBody
    public R showWeekSchedule(int stuId, String year, int week){
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
    public R showDaySchedule(int stuId, String year, int week,int day){
        if(stuId<0 || year.equals("") || week<0  || day<0 || day>=7){
            return error("参数不正确");
        }else {
            List<course> list=stuCourseService.findCoursesOfDay(stuId,year,(byte)week,(byte)day);
            return reToObj(list);
        }
    }

    /**
        添加课程表
     */
    @PostMapping("addSchedule")
    @ResponseBody
    public R addSchedule(@RequestBody course course,
                         @RequestParam(value = "stuId") int stuId){
        int courseId=courseservice.addCourse(course);
        int n=stuCourseService.addStuCourse(stuId,courseId);
        if (n==1){
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
    public R bulletCommentsInWeek(@RequestParam int majorId,
                                  @RequestParam String year,
                                  @RequestParam int week){
        List<String> list=bulletCommentsService.showWeekComments(majorId,year,week);
        return reToObj(list);
    }

    /**
     * 添加备忘录
     * 请求课表的时候返回每个课程的id
     */
    @RequestMapping("addMemo")
    @ResponseBody
    public R addMemo(@RequestParam(value = "stuId") int stuId,
                     @RequestParam(value = "courseId")int courseId,
                     @RequestParam(value = "content") String content){
        int id=memoservice.addMemo(stuId,courseId,content);
        return reToObj(id);
    }
    /**
     * 修改备忘录
     */
    @RequestMapping("editMemo")
    @ResponseBody
    public R editMemo(@RequestParam(value = "memoId")int memoId,
                     @RequestParam(value = "content") String content){
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
    public R deleteMemo(@RequestParam(value = "memoId")int memoId){
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
    public R showMemoInWeek(int stuId,String year,int week){
        List<course> courses=stuCourseService.findCoursesOfWeek(stuId,year, (byte) week);
        List<memo> memos=memoservice.showMemoInWeek(stuId,courses);
        return reToObj(memos);
    }

    /**
     * 显示课程具体信息
     */
    @RequestMapping("showCourseDetail")
    @ResponseBody
    public R showCourseDetail(int courseId){
        course c=courseservice.findCourseById(courseId);
        return reToObj(c);
    }

    /**
     * 上传背景图 返回图片路径
     */
    @RequestMapping("uploadBgImg")
    @ResponseBody
    public R uploadBgImg(HttpServletRequest request,
                         @RequestParam(value = "stuId") int stuId,
                         @RequestParam(value = "file") MultipartFile file){
        try {
            if(!file.isEmpty()){
                String path= backgroundService.saveBgImg(request,stuId, file);
                if(!path.isEmpty()){
                    return success("path",path);
                }
            }
            return error();
        }catch (Exception e){
            return error(e.getMessage());
        }

    }
    /**
     * 请求背景图 返回图片路径
     */
    @RequestMapping("showBgImg")
    @ResponseBody
    public R showBgImg(int stuId){
        String path=backgroundService.findImgByStuId(stuId);
        if (path!=null){
            return success("path",path);
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
                       @RequestParam(value = "stuId") int stuId,
                       @RequestParam(value = "year")String year){
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
    @GetMapping("getSentence")
    @ResponseBody
    public R getSentence() {
        Sentence result=sentenceservice.getSentence();
        if (result!=null)return reToObj(result);
        return error();
    }

    /**
     * 获取一个学期的课程
     */

    @GetMapping("getCoursesOfSemester")
    @ResponseBody
    public  R getCoursesOfSemester(int stuId,String year){
        List result=stuCourseService.findCourseOfSemester(stuId,year);
        return reToObj(result);
    }



}
