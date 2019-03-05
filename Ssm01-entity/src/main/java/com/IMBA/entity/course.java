package com.IMBA.entity;

public class course extends courseKey {
    private Byte dayOfWeek;

    private Byte weekOfSemester;

    private Byte lessonOfDay;

    private String courseTime;

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

    public Byte getLessonOfDay() {
        return lessonOfDay;
    }

    public void setLessonOfDay(Byte lessonOfDay) {
        this.lessonOfDay = lessonOfDay;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }
}