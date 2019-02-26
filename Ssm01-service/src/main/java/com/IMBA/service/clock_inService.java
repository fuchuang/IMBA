package com.IMBA.service;

import com.IMBA.entity.clock_in;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface clock_inService {
    int insert(clock_in record);

    //查找学年考勤表
    Map<String,Map<Integer,String>> getAttendanceRecord(int stuId,
                                          String year);
}
