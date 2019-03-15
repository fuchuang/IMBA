package com.IMBA.service;

public interface stu_examService {
    //更新是否标记到课表
    boolean updateIsOnSchedule(int stuExamId,boolean isOn,int stu_course_exam_id);

    //是否标记到课表
    boolean isOnSchedule(int stuId,int examId);

}
