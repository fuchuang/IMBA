package com.IMBA.entity;

public class video_series {
    private Integer id;

    private String courseLecturer;

    private String courseTitle;

    private String courseType;

    private Integer watchingNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(String courseLecturer) {
        this.courseLecturer = courseLecturer == null ? null : courseLecturer.trim();
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle == null ? null : courseTitle.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public Integer getWatchingNum() {
        return watchingNum;
    }

    public void setWatchingNum(Integer watchingNum) {
        this.watchingNum = watchingNum;
    }
}