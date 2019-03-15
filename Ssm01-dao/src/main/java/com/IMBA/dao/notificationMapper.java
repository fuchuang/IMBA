package com.IMBA.dao;

import com.IMBA.dto.noticesDto;
import com.IMBA.entity.notification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface notificationMapper {
    List<noticesDto> selectByStuId(@Param("stuId") Integer stuId, @Param("limit") Integer limit, @Param("offset") Integer offset);

    List<noticesDto> selectCollection(@Param("stuId") Integer stuId, @Param("limit") Integer limit, @Param("offset") Integer offset);

    notification selectById(Integer id);

    int insertAndGetId(notification record);

    List<noticesDto> selectBYTime(@Param("stuId") Integer stuId, @Param("limit") Integer limit, @Param("offset") Integer offset);

    int getRecentlyViewedCount(int stuId);

    int getCollectionCount(int stuId);

    int getNoticesCount(int stuId);


    int deleteByPrimaryKey(Integer id);

    int insert(notification record);

    int insertSelective(notification record);

    notification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(notification record);

    int updateByPrimaryKeyWithBLOBs(notification record);

    int updateByPrimaryKey(notification record);
}