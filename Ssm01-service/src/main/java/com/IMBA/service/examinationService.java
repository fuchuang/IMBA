package com.IMBA.service;

import com.IMBA.dto.examResultDto;
import com.IMBA.entity.examination;

import java.util.List;

public interface examinationService {


    //查看考试列表
    List<examResultDto> getExams(int stuId);

    //把考试添加到课表 返回生成的course_exam_id
    int addToSchedule(int stuId,int examId,int stuExamId);

    //取消标记考试
    boolean cancelAddToSchedule(int stuExamId,int courseExamId);
}
