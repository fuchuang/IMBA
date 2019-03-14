package com.IMBA.service;
import com.IMBA.entity.course;
import com.IMBA.utils.JsonUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface ScheduleService {

    //添加课程
    public void addCourse(int stuID,String courseName,String courseSite,String year,int week,int dayOfWeek,int from,int to);

    //发弹幕
    public void addBulletComments(int stuID,String content);

    //添加备忘录
    public void addMemo(int stuID,String content,int year,int week,int dayOfWeek,int lesson);

    //显示课程信息
    public course showCourseDetail(int year,int week,int dayOfWeek,int lesson);

    //添加背景图
    public String addBbImg(int STUid, File file);

    //生成个人课表的二维码
    public String showQRcode(int stuID);

    //返回一天的课程
    public List<course> showCousesOfDay(int stuID,int year,int week,int dayOfWeek);

    //返回一周的课程
    public List<List<course>> showCousesOfWeek(int stuID,int year,int week);

    //每日一 词 金山词霸api
    public String wordOfDay();
}
