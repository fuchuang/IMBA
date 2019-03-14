package com.IMBA.dao;

import com.IMBA.entity.clock_in;
import com.IMBA.entity.clock_inKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface clock_inMapper {

    int selectclockin_today(int stu_id);
    int selectclockin_nums(int stu_id);
    int deleteByPrimaryKey(clock_inKey key);





    int insert(clock_in record);

    int insertSelective(clock_in record);

    clock_in selectByPrimaryKey(clock_inKey key);

    int updateByPrimaryKeySelective(clock_in record);

    int updateByPrimaryKey(clock_in record);
}