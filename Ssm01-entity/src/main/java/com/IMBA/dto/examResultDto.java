package com.IMBA.dto;

import com.IMBA.entity.examination;

public class examResultDto extends examination {

    private int stuExamId;

    private String courseName;

    private int stuExamCourseId;

    public int getStuExamCourseId() {
        return stuExamCourseId;
    }

    public void setStuExamCourseId(int stuExamCourseId) {
        this.stuExamCourseId = stuExamCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getStuExamId() {
        return stuExamId;
    }

    public void setStuExamId(int stuExamId) {
        this.stuExamId = stuExamId;
    }
}
