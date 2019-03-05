package com.IMBA.entity;

import java.util.ArrayList;
import java.util.List;

public class course {
    private Integer id;

    private String courseName;

    private String classroom;

    private Float courseCredit;

    private Integer courseHour;

    private Integer courseQuota;

    private Byte dayOfWeek;

    private Byte weekOfSemester;

    private Byte lessonOfDay;

    private String courseYear;

    private String courseType;

    private String courseTime;

    private String teacher;

    private List<major> classes=new ArrayList<major>(); //上该课程的所有班级列表


    public List<major> getClasses() {
        return classes;
    }

    public void setClasses(List<major> classes) {
        this.classes = classes;
    }
    public void addMajor(major m){
        this.classes.add(m);
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public Float getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Float courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Integer getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(Integer courseHour) {
        this.courseHour = courseHour;
    }

    public Integer getCourseQuota() {
        return courseQuota;
    }

    public void setCourseQuota(Integer courseQuota) {
        this.courseQuota = courseQuota;
    }

    public Byte getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Byte dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Byte getWeekOfSemester() {
        return weekOfSemester;
    }

    public void setWeekOfSemester(Byte weekOfSemester) {
        this.weekOfSemester = weekOfSemester;
    }

    public Byte getLessonOfDay() {
        return lessonOfDay;
    }

    public void setLessonOfDay(Byte lessonOfDay) {
        this.lessonOfDay = lessonOfDay;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear == null ? null : courseYear.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }

    public void setCourseDetail(course c){
        this.setClassroom(c.classroom);
        this.setTeacher(c.teacher);
        this.setCourseTime(c.courseTime);
        this.setCourseName(c.courseName);

    }
}