package com.IMBA.model;

import java.util.List;

public class videolistmodel {
    private List<videomodel>videomodels;
    private String course_lecturer;
    private String course_title;
    private int id;

    public List<videomodel> getVideomodels() {
        return videomodels;
    }

    public void setVideomodels(List<videomodel> videomodels) {
        this.videomodels = videomodels;
    }

    public String getCourse_lecturer() {
        return course_lecturer;
    }

    public void setCourse_lecturer(String course_lecturer) {
        this.course_lecturer = course_lecturer;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
