package com.IMBA.service.impl;

import com.IMBA.dao.teacher_questionnaireMapper;
import com.IMBA.entity.teacher_questionnaire;
import com.IMBA.service.teacher_questionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*@Service*/
public class teacher_questionnaireServiceImpl implements teacher_questionnaireService {
    @Autowired
    teacher_questionnaireMapper teacherQuestionnaireMapper;

    public int insert(teacher_questionnaire record) {
        return teacherQuestionnaireMapper.insert(record);
    }

    public List<teacher_questionnaire> findteacher_questionnaire(int courseinfoid) {
        return teacherQuestionnaireMapper.findteacher_questionnaire(courseinfoid);
    }
}
