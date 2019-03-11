package com.IMBA.service.impl;

import com.IMBA.dao.examinationMapper;
import com.IMBA.dto.examResultDto;
import com.IMBA.entity.course;
import com.IMBA.entity.examination;
import com.IMBA.entity.examinationKey;
import com.IMBA.service.courseService;
import com.IMBA.service.examinationService;
import com.IMBA.service.stu_examService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service("examinationService")
public class examinationServiceImpl implements examinationService {
    @Autowired
    examinationMapper examinationmapper;
    @Autowired
    courseService courseservice;
    @Autowired
    stu_examService stuExamService;


    public List<examResultDto> getExams(int stuId) {
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        String schoolYear;
        if (3<month && month<9){
            schoolYear=year+"年上半学期";
        }else {
            schoolYear=year+"年下半学期";
        }
        List<examResultDto> result=examinationmapper.selectByYear(schoolYear,stuId);
        return result;
    }



    public boolean addToSchedule(int stuId, int examId) {
        //标记学生-考试 的isOnschedule 2.把考试包装成课程
        stuExamService.updateIsOnSchedule(stuId,examId,true);
        examResultDto exam=examinationmapper.selectById(examId);
        boolean ok=courseservice.examToCourse(exam);
        return ok;
    }
}
