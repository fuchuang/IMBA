package com.IMBA.service;

import com.IMBA.dto.courseScoresDto;

import java.util.List;

public interface scoreService {
    //查询某个学期绩点
    float getGPAByTerm(int stuId,String year);

    //查询目前所有课的平均绩点
    float getAverageGPA(int stuId);

    //查询某个学期全部课程成绩
    List<courseScoresDto> getScoresByTerm(int stuId, String year);

    //查询绩点排行 先计算同专业所有人的绩点 再进行排行
    int getRankInMajor(int stuId,String year);
}
