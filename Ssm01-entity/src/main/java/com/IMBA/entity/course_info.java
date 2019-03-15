package com.IMBA.entity;

public class course_info {
    private Integer id;

    private String courseName;

    private Float courseCredit;

    private Byte courseHour;

    private Integer courseQuota;

    private String classroom;

    private String courseType;

    private String courseYear;

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

    public Float getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Float courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Byte getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(Byte courseHour) {
        this.courseHour = courseHour;
    }

    public Integer getCourseQuota() {
        return courseQuota;
    }

    public void setCourseQuota(Integer courseQuota) {
        this.courseQuota = courseQuota;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear == null ? null : courseYear.trim();
    }
}