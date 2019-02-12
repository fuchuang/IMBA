package com.IMBA.entity;

import java.util.Date;

public class course_files extends course_filesKey {
    private String filesTitle;

    private String filesPath;

    private Date uploadTime;

    public String getFilesTitle() {
        return filesTitle;
    }

    public void setFilesTitle(String filesTitle) {
        this.filesTitle = filesTitle == null ? null : filesTitle.trim();
    }

    public String getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath == null ? null : filesPath.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}