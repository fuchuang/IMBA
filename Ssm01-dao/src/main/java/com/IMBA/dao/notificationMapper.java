package com.IMBA.dao;

import com.IMBA.dto.noticesDto;
import com.IMBA.entity.notification;

import java.util.List;

public interface notificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(notification record);

    int insertSelective(notification record);

    notification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(notification record);

    int updateByPrimaryKeyWithBLOBs(notification record);

    int updateByPrimaryKey(notification record);

    List<noticesDto> selectByStuId(Integer stuId);

    List<noticesDto> selectCollection(Integer stuId);

    notification selectById(Integer id);

    int insertAndGetId(notification record);
}