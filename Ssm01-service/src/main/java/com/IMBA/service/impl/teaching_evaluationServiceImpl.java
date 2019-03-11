package com.IMBA.service.impl;

import com.IMBA.dao.teaching_evaluationMapper;
import com.IMBA.entity.teaching_evaluation;
import com.IMBA.service.teaching_evaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teaching_evaluationService")
public class teaching_evaluationServiceImpl implements teaching_evaluationService {
    @Autowired
    teaching_evaluationMapper mapper;

    public boolean addEvaluation(int studentId, int teacherId, float grade) {
        teaching_evaluation record=new teaching_evaluation();
        record.setSatisfaction(grade);
        record.setTeacherId(teacherId);
        record.setStudentId(studentId);
        int n=mapper.insertAndGetId(record);
        if (n==1)return true;
        return false;
    }

    public boolean findBystuIdAndTeacherId(int stuId, int teacherId) {
        teaching_evaluation te=new teaching_evaluation();
        te.setStudentId(stuId);
        te.setTeacherId(teacherId);
        if (mapper.selectByStudentIdAndTeacherId(te)!=null)return true;
        return false;
    }

}
