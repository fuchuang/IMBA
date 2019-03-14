package com.IMBA.dao;

import com.IMBA.entity.electiveLikes;

public interface elective_LikesMapper {

    electiveLikes selectByPrimaryKey(electiveLikes record);

    int insert(electiveLikes record);

    int deleteByPrimaryKey(electiveLikes record);


}
