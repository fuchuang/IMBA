package com.IMBA.model;

import java.util.Date;

public class postmodel {
    private Boolean isanonymity;

    private String postsTitle;

    private String postsTags;

    private String postsTime;

    private String postsContent;

    private String name;
    private int id;
    private int stuid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

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
        this.postsTitle = postsTitle;
    }

    public String getPostsTags() {
        return postsTags;
    }

    public void setPostsTags(String postsTags) {
        this.postsTags = postsTags;
    }

    public String getPostsTime() {
        return postsTime;
    }

    public void setPostsTime(String postsTime) {
        this.postsTime = postsTime;
    }

    public String getPostsContent() {
        return postsContent;
    }

    public void setPostsContent(String postsContent) {
        this.postsContent = postsContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
