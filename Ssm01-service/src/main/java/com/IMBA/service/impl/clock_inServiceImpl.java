package com.IMBA.service.impl;

import com.IMBA.dao.clock_inMapper;
import com.IMBA.dto.attendanceRecordDto;
import com.IMBA.entity.clock_in;
import com.IMBA.service.clock_inService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*@Service("clock_inService")*/
public class clock_inServiceImpl implements clock_inService {
    @Resource
    clock_inMapper clockInMapper;

    public int insert(clock_in record) {
        clockInMapper.insert(record);
        return 0;
    }

    public int selectclockin_today(int stu_id) {
        return clockInMapper.selectclockin_today(stu_id);
    }

    public int selectclockin_nums(int stu_id) {
        return clockInMapper.selectclockin_nums(stu_id);
    }


    public Map<String, Map<Integer,String>> getAttendanceRecord(int stuId, String year) {
        Map<String,Map<Integer,String>> result=new HashMap<String,Map<Integer,String>>();
        List<attendanceRecordDto> list=clockInMapper.selectAttendanceRecordByYear(stuId,year);
        for (int i=0;i<list.size();i++){
            attendanceRecordDto ard=list.get(i);
            Map smap=result.get(ard.getCourseName());
            if(smap!=null){
                smap.put(ard.getWeek(),ard.getStatus());
            }else {
                Map<Integer,String> map=new HashMap<Integer, String>();
                map.put(ard.getWeek(),ard.getStatus());
                result.put(ard.getCourseName(),map);
            }
        }
        return result;
    }

}
