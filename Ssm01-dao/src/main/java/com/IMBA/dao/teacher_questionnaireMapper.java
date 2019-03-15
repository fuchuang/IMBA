package com.IMBA.dao;

import com.IMBA.entity.teacher_questionnaire;

import java.util.List;

public interface teacher_questionnaireMapper {

    int insert(teacher_questionnaire record);
    //问卷列表
    List<teacher_questionnaire>findteacher_questionnaire(int courseinfoid);

    int deleteByPrimaryKey(Integer id);



    int insertSelective(teacher_questionnaire record);

    teacher_questionnaire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(teacher_questionnaire record);

    int updateByPrimaryKey(teacher_questionnaire record);
}