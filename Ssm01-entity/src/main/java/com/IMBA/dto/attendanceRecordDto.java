package com.IMBA.dto;

public class attendanceRecordDto {
    private String courseName;
    private int week;
    private String status;
    private int stuCourseId;

    public int getStuCourseId() {
        return stuCourseId;
    }

    public void setStuCourseId(int stuCourseId) {
        this.stuCourseId = stuCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
