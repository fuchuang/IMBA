package com.IMBA.dao;

import com.IMBA.entity.schedule_background;
import com.IMBA.entity.schedule_backgroundKey;

public interface schedule_backgroundMapper {
    int deleteByPrimaryKey(schedule_backgroundKey key);

    int insert(schedule_background record);

    int insertSelective(schedule_background record);

    schedule_background selectByPrimaryKey(schedule_backgroundKey key);

    int updateByPrimaryKeySelective(schedule_background record);

    int updateByPrimaryKey(schedule_background record);

    schedule_background selectByStuId(Integer studentId);

    int updateByStuId(schedule_background record);

   // schedule_background findByStuId(Integer stuId);
}