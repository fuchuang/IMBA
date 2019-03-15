package com.IMBA.service.impl;

import com.IMBA.dao.stu_notificationMapper;
import com.IMBA.entity.stu_notification;
import com.IMBA.service.stu_notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stu_notificationService")
public class stu_notificationServiceImpl implements stu_notificationService {
    @Autowired
    stu_notificationMapper mapper;

    public boolean addItem(int stuId, int noticesId) {
        stu_notification sn=new stu_notification();
        sn.setStudentId(stuId);
        sn.setNotificationId(noticesId);
        sn.setIsCollect(true);
        sn.setReadStatus(false);
        try{
            mapper.insertSelective(sn);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateItem(stu_notification record) {
        int n=mapper.updateByPrimaryKeySelective(record);
        if (n==1)return true;
        return false;
    }

    public stu_notification getById(int stuId, int noticeId) {
        return mapper.selectBystuIdAndNoticeId(stuId,noticeId);
    }
}
