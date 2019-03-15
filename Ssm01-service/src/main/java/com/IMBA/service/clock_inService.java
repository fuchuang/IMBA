package com.IMBA.service;

import com.IMBA.entity.clock_in;

import java.util.Map;

public interface clock_inService {
    int insert(clock_in record);
    int selectclockin_today(int stu_id);
    int selectclockin_nums(int stu_id);

    //查找学年考勤表
    Map<String, Map<Integer,String>> getAttendanceRecord(int stuId,
                                                         String year);

}
