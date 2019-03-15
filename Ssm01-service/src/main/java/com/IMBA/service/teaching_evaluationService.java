package com.IMBA.service;

public interface teaching_evaluationService {
    float findsatisfaction(int courseinfoid);
    //添加评价
    boolean addEvaluation(int studentId,int teacherId,float grade);

    boolean findBystuIdAndTeacherId(int stuId,int teacherId);

}
