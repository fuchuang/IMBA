package com.IMBA.service.impl;

import com.IMBA.dao.clock_inMapper;
import com.IMBA.entity.clock_in;
import com.IMBA.service.clock_inService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("clock_inService")
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


}
