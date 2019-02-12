package com.IMBA.entity;

import java.util.Date;

public class elective_comments extends elective_commentsKey {
    private String commentContent;

    private Date commentTime;

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}