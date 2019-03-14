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
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional(rollbackFor=Exception.class)
    public int addToSchedule(int stuId,int examId,int stuExamId) {
        int course_exam_id=-1;
        examResultDto exam=examinationmapper.selectById(examId);
        if (exam!=null){
             course_exam_id=courseservice.examToCourse(exam,stuId);
            stuExamService.updateIsOnSchedule(stuExamId,true,course_exam_id);
            return 1;
        }
        return -1;

    }

    @Transactional(rollbackFor=Exception.class)
    public boolean cancelAddToSchedule(int stuExamId,int courseExamId) {
        try {
            stuExamService.updateIsOnSchedule(stuExamId,false,-1);
            courseservice.deleteExamToCourse(courseExamId);
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
