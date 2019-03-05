package com.IMBA.service;

import com.IMBA.model.studentregistermodel;

import java.util.List;

public interface stu_courseService {
    int findcount(int courseid);
    List<studentregistermodel>findstudentregistermodel(int courseinfoid,int day_of_week,int week_of_semester,int lesson_of_day);
}
