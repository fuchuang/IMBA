package com.IMBA.dao;

import com.IMBA.entity.stu_notification;
import com.IMBA.entity.stu_notificationKey;
import org.apache.ibatis.annotations.Param;

public interface stu_notificationMapper {



    stu_notification selectBystuIdAndNoticeId(@Param("stuId")Integer studentId, @Param("noticeId")Integer notificationId);

    int deleteByPrimaryKey(stu_notificationKey key);

    int insert(stu_notification record);

    int insertSelective(stu_notification record);

    stu_notification selectByPrimaryKey(stu_notificationKey key);

    int updateByPrimaryKeySelective(stu_notification record);

    int updateByPrimaryKey(stu_notification record);
}