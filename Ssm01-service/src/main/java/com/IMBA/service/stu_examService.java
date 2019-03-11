package com.IMBA.service;

public interface stu_examService {
    //更新是否标记到课表
    boolean updateIsOnSchedule(int stuId,int examId,boolean isOn);

    //是否标记到课表
    boolean isOnSchedule(int stuId,int examId);
}
