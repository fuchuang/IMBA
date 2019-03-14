package com.IMBA.dto;


public class electiveResultDto  {
    private Integer likesNumber;
    private Integer id;
    private String courseName;
    private String teacher;
    private Integer courseHour;
    private Float courseCredit;
    private boolean isCollected;
    private boolean isLike;      //是否点赞

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public Integer getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(Integer courseHour) {
        this.courseHour = courseHour;
    }

    public Float getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Float courseCredit) {
        this.courseCredit = courseCredit;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
