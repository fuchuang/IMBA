package com.IMBA.dao;

import com.IMBA.entity.stu_courseKey;
import com.IMBA.model.studentregistermodel;

import java.util.List;

public interface stu_courseMapper {
    int findcount(int courseid);
    List<studentregistermodel>findstudentregistermodel(int courseinfoid,int day_of_week,int week_of_semester,int lesson_of_day);

    int deleteByPrimaryKey(stu_courseKey key);

    int insert(stu_courseKey record);

    int insertSelective(stu_courseKey record);
}