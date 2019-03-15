package com.IMBA.service;

import com.IMBA.dto.teachInfoDto;

import java.util.List;

public interface teacherService {

    //查询教师列表
    List<teachInfoDto> getTeachersInfo(int stuId);

//    点赞教师
    boolean addLikes(int stuId,int teacherId);

    //取消点赞
    boolean cancelLikes(int stuId,int teacherId);

    //评分
    boolean evaluteTeacher(int stuId,int teacherId,float grade);

//    查询教师评分
    float getEvaluateById(int teacherId);
}
