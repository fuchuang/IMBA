package com.IMBA.service;

import com.IMBA.dto.examResultDto;
import com.IMBA.entity.examination;

import java.util.List;

public interface examinationService {


    //查看考试列表
    List<examResultDto> getExams(int stuId);
}
