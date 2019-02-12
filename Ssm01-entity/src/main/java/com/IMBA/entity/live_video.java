package com.IMBA.entity;

import java.util.Date;

public class live_video extends live_videoKey {
    private Integer watchingNum;

    private String liveTitle;

    private String livePath;

    private Date startTime;

    private Boolean liveStatus;

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