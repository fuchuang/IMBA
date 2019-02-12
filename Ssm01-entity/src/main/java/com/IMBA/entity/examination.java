package com.IMBA.entity;

public class examination extends examinationKey {
    private String site;

    private String invigilator;

    private Byte dayOfWeek;

    private Byte weekOfSemester;

    private String examTime;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(String invigilator) {
        this.invigilator = invigilator == null ? null : invigilator.trim();
    }

    public Byte getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Byte dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Byte getWeekOfSemester() {
        return weekOfSemester;
    }

    public void setWeekOfSemester(Byte weekOfSemester) {
        this.weekOfSemester = weekOfSemester;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime == null ? null : examTime.trim();
    }
}