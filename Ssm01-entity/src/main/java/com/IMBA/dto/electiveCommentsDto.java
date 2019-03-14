package com.IMBA.dto;

import java.util.Date;

public class electiveCommentsDto {
    private Integer studentId;
    private String AvatarPath;
    private Date date;
    private String content;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getAvatarPath() {
        return AvatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        AvatarPath = avatarPath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
