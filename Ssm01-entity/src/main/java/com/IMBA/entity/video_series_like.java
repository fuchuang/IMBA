package com.IMBA.entity;

public class video_series_like {
    private Integer id;

    private Integer videoSeries;

    private Integer stuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoSeries() {
        return videoSeries;
    }

    public void setVideoSeries(Integer videoSeries) {
        this.videoSeries = videoSeries;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}