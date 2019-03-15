package com.IMBA.entity;

import java.util.Date;

public class posts_comments extends posts_commentsKey {
    private String commentsContent;

    private Date commentsTime;

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent == null ? null : commentsContent.trim();
    }

    public Date getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(Date commentsTime) {
        this.commentsTime = commentsTime;
    }
}