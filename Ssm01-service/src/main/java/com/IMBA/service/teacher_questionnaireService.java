package com.IMBA.service;

import com.IMBA.entity.teacher_questionnaire;

import java.util.List;

public interface teacher_questionnaireService {
    int insert(teacher_questionnaire record);
    List<teacher_questionnaire> findteacher_questionnaire(int courseinfoid);
}
