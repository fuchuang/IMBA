package com.IMBA.dao;

import com.IMBA.entity.examination;
import com.IMBA.entity.examinationKey;

public interface examinationMapper {
    int deleteByPrimaryKey(examinationKey key);

    int insert(examination record);

    int insertSelective(examination record);

    examination selectByPrimaryKey(examinationKey key);

    int updateByPrimaryKeySelective(examination record);

    int updateByPrimaryKey(examination record);
}