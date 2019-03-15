package com.IMBA.dto;

public class watchedVideoDto {
    private String courseLecturer;

    private String courseTitle;

    private Integer watchingNum;

    private String videoPath;


    private String videoImgPath;

    private Float watchProgress;

    public String getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(String courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Integer getWatchingNum() {
        return watchingNum;
    }

    public void setWatchingNum(Integer watchingNum) {
        this.watchingNum = watchingNum;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoImgPath() {
        return videoImgPath;
    }

    public void setVideoImgPath(String videoImgPath) {
        this.videoImgPath = videoImgPath;
    }

    public Float getWatchProgress() {
        return watchProgress;
    }

    public void setWatchProgress(Float watchProgress) {
        this.watchProgress = watchProgress;
    }
}
