package com.IMBA.entity;

public class bullet_comments extends bullet_commentsKey {
    private Byte weekOfSemester;

    private String content;

    private String academicYear;

    public Byte getWeekOfSemester() {
        return weekOfSemester;
    }

    public void setWeekOfSemester(Byte weekOfSemester) {
        this.weekOfSemester = weekOfSemester;
    }

    public String getContent() {
        return content;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}