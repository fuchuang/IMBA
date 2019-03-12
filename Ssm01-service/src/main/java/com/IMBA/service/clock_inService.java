package com.IMBA.service;

import com.IMBA.entity.clock_in;

public interface clock_inService {
    int insert(clock_in record);
    int selectclockin_today(int stu_id);
    int selectclockin_nums(int stu_id);

}
