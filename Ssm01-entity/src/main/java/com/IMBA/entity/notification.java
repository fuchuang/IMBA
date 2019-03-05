package com.IMBA.entity;

import java.util.Date;

public class notification {
    private Integer id;

    private Date notiDate;

    private String notiSummarized;

    private String notiTitle;

    private String notiContent;

    private String attachedFilePath;

    private boolean isCollect;

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNotiDate() {
        return notiDate;
    }

    public void setNotiDate(Date notiDate) {
        this.notiDate = notiDate;
    }

    public String getNotiSummarized() {
        return notiSummarized;
    }

    public void setNotiSummarized(String notiSummarized) {
        this.notiSummarized = notiSummarized == null ? null : notiSummarized.trim();
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle == null ? null : notiTitle.trim();
    }

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent == null ? null : notiContent.trim();
    }
    public String getAttachedFilePath() {
        return attachedFilePath;
    }

    public void setAttachedFilePath(String attachedFilePath) {
        this.attachedFilePath = attachedFilePath;
    }
}