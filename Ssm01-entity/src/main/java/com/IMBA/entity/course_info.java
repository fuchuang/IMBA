package com.IMBA.entity;

public class course_info {
    private int id;

    private String course_name;

    private String classroom;

    private Float courseCredit;

    private Integer courseHour;

    private Integer courseQuota;

    private String courseYear;

    private String courseType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
}
