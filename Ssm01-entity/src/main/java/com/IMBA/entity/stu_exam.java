package com.IMBA.entity;

public class stu_exam extends stu_examKey {
    private Integer seatNumber;

    private boolean isOnSchedule;

    private int exam_stu_course_id;

    public int getExam_stu_course_id() {
        return exam_stu_course_id;
    }

    public void setExam_stu_course_id(int exam_stu_course_id) {
        this.exam_stu_course_id = exam_stu_course_id;
    }

    public boolean isOnSchedule() {
        return isOnSchedule;
    }

    public void setOnSchedule(boolean onSchedule) {
        isOnSchedule = onSchedule;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}