package com.IMBA.service.impl;

import com.IMBA.dao.stu_examMapper;
import com.IMBA.entity.stu_exam;
import com.IMBA.service.stu_examService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stu_examService")
public class stu_examServiceImpl implements stu_examService {
    @Autowired
    stu_examMapper mapper;

    public boolean updateIsOnSchedule(int stuId,int examId,boolean isOn) {
        stu_exam record=new stu_exam();
        record.setStudentId(stuId);
        record.setExaminationId(examId);
        record.setOnSchedule(isOn);
        int n=mapper.updateIsOnScheduleByStuIdAndExamId(record);
        if (n==1)return true;
        return false;
    }

    public boolean isOnSchedule(int stuId, int examId) {
        stu_exam record=new stu_exam();
        record.setStudentId(stuId);
        record.setExaminationId(examId);
        record=mapper.selectByStuIdAndExamId(record);
        if (record.isOnSchedule())return true;
        return false;
    }
}
