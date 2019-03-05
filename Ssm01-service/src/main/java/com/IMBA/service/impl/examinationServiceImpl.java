package com.IMBA.service.impl;

import com.IMBA.dao.examinationMapper;
import com.IMBA.dto.examResultDto;
import com.IMBA.entity.examination;
import com.IMBA.entity.examinationKey;
import com.IMBA.service.examinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service("examinationService")
public class examinationServiceImpl implements examinationService {
    @Autowired
    examinationMapper examinationmapper;


    public List<examResultDto> getExams(int stuId) {
        //根据现在的日期 判断学年 再返回该学年的课程 根据课程id判断学年
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
}
