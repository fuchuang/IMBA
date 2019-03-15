package com.IMBA.entity;

public class major {
    private Integer id;

    private String marjorName;

    private Integer classes;

    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarjorName() {
        return marjorName;
    }

    public void setMarjorName(String marjorName) {
        this.marjorName = marjorName == null ? null : marjorName.trim();
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}