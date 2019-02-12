package com.IMBA.entity;

import java.util.Date;

public class posts extends postsKey {
    private Boolean isanonymity;

    private String postsTitle;

    private String postsTags;

    private Date postsTime;

    private String postsContent;

    public Boolean getIsanonymity() {
        return isanonymity;
    }

    public void setIsanonymity(Boolean isanonymity) {
        this.isanonymity = isanonymity;
    }

    public String getPostsTitle() {
        return postsTitle;
    }

    public void setPostsTitle(String postsTitle) {
        this.postsTitle = postsTitle == null ? null : postsTitle.trim();
    }

    public String getPostsTags() {
        return postsTags;
    }

    public void setPostsTags(String postsTags) {
        this.postsTags = postsTags == null ? null : postsTags.trim();
    }

    public Date getPostsTime() {
        return postsTime;
    }

    public void setPostsTime(Date postsTime) {
        this.postsTime = postsTime;
    }

    public String getPostsContent() {
        return postsContent;
    }

    public void setPostsContent(String postsContent) {
        this.postsContent = postsContent == null ? null : postsContent.trim();
    }
}