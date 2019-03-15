package com.IMBA.model;

import java.util.Date;

public class livemodel {
    private int id;

    private String stu_name;
    private Integer watchingNum;

    private String liveTitle;

    private String livePath;

    private Date startTime;

    private Boolean liveStatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public Integer getWatchingNum() {
        return watchingNum;
    }

    public void setWatchingNum(Integer watchingNum) {
        this.watchingNum = watchingNum;
    }

    public String getLiveTitle() {
        return liveTitle;
    }

    public void setLiveTitle(String liveTitle) {
        this.liveTitle = liveTitle == null ? null : liveTitle.trim();
    }

    public String getLivePath() {
        return livePath;
    }

    public void setLivePath(String livePath) {
        this.livePath = livePath == null ? null : livePath.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Boolean getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Boolean liveStatus) {
        this.liveStatus = liveStatus;
    }
}
