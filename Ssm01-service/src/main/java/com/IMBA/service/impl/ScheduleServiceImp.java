package com.IMBA.service.impl;

import com.IMBA.entity.*;
import com.IMBA.service.ScheduleService;
import com.IMBA.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService {

    @Autowired
    public courseMapper CourseMapper;

    @Autowired
    public stu_courseMapper stuCourseMapper;


    public void addCourse(int stuID,String courseName, String courseSite, String year, int week, int dayOfWeek, int from, int to) {
        if(from>to)return;

        for (int i=from;i<=to;i++){
            course newCourse=new course();
            newCourse.setClassroom(courseSite);
            newCourse.setCourseName(courseName);
            newCourse.setCourseYear(year);
            newCourse.setWeekOfSemester((byte) week);
            newCourse.setDayOfWeek((byte) dayOfWeek);
            newCourse.setLessonOfDay((byte) i);

            stu_courseKey stuCourseKey=new stu_courseKey();

           CourseMapper.insertAndGetId(newCourse);
           stuCourseKey.setCourseId(newCourse.getId());
           stuCourseKey.setStudentId(stuID);
           //System.out.println(newCourse.getId()+"、"+stuID);
           //stuCourseMapper.insertSelective(stuCourseKey);

        }

    }

    public void addBulletComments(int stuID, String content) {

    }

    public void addMemo(int stuID, String content, int year, int week, int dayOfWeek, int lesson) {

    }

    public course showCourseDetail(int year, int week, int dayOfWeek, int lesson) {
        return null;
    }

    public String addBbImg(int STUid, File file) {
        return null;
    }

    public String showQRcode(int stuID) {
        return null;
    }

    public List<course> showCousesOfDay(int stuID, int year, int week, int dayOfWeek) {
        return null;
    }

    public List<List<course>> showCousesOfWeek(int stuID, int year, int week) {
        return null;
    }

    public String wordOfDay() {
        return null;
    }


}
