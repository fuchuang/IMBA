package com.IMBA.dto;

import com.IMBA.entity.teacher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class teachInfoDto implements Serializable {
    private Integer id;

    private List<String> coursesName;

    private String teacherName;

    private String avatarPath;

    private String office;

    private String phoneNumber;

    private String eMail;

    private Integer likesNumber;

    private boolean isLike;

    private boolean isEvaluate;  //是否已评价

    public boolean isEvaluate() {
        return isEvaluate;
    }

    public void setEvaluate(boolean evaluate) {
        isEvaluate = evaluate;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public List<String> getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(List<String> coursesName) {
        this.coursesName = coursesName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(Integer likesNumber) {
        this.likesNumber = likesNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTeacher(teacher t, String courseName){
        this.setId(t.getId());
        this.setAvatarPath(t.getAvatarPath());
        this.seteMail(t.getAvatarPath());
        this.setLikesNumber(t.getLikesNumber());
        this.setOffice(t.getOffice());
        this.setPhoneNumber(t.getPhoneNumber());
        this.setTeacherName(t.getTeacherName());
        this.coursesName=new ArrayList<String>();
        this.coursesName.add(courseName);
    }
}
