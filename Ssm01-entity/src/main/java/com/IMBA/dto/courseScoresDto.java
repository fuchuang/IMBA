package com.IMBA.dto;

public class courseScoresDto {
    String courseName;
    float score;
    float courseCredit;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(float courseCredit) {
        this.courseCredit = courseCredit;
    }
}
