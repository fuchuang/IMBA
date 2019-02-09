package com.IMBA.dao;

import com.IMBA.entity.teaching_evaluation;
import com.IMBA.entity.teaching_evaluationKey;

public interface teaching_evaluationMapper {
    int deleteByPrimaryKey(teaching_evaluationKey key);

    int insert(teaching_evaluation record);

    int insertSelective(teaching_evaluation record);

    teaching_evaluation selectByPrimaryKey(teaching_evaluationKey key);

    int updateByPrimaryKeySelective(teaching_evaluation record);

    int updateByPrimaryKey(teaching_evaluation record);
}