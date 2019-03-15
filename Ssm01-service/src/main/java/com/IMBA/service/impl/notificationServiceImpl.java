package com.IMBA.service.impl;

import com.IMBA.dao.notificationMapper;
import com.IMBA.dto.noticesDto;
import com.IMBA.entity.notification;
import com.IMBA.entity.stu_notification;
import com.IMBA.service.notificationService;
import com.IMBA.service.stu_notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("notificationService")
public class notificationServiceImpl implements notificationService {
    @Autowired
    notificationMapper mapper;
    @Autowired
    stu_notificationService stuNotificationService;

    public List<noticesDto> findCollectionsByStuId(int stuId, int offset, int limit) {
        List<noticesDto> list=mapper.selectCollection(stuId,offset,limit);
        return list;
    }
    public notification noticesDetail(int stuId, int id) {
        //请求一次通知的详情即是最近阅读 设置阅读时间
        notification notice=mapper.selectById(id);
        stu_notification sn=stuNotificationService.getById(stuId,id);
        if (sn!=null){
            sn.setReadTime(new Timestamp(System.currentTimeMillis()));
            sn.setReadStatus(true);
            stuNotificationService.updateItem(sn);
        }

        return notice;
    }



    public int getCollectionCount(int stuId) {
        return mapper.getCollectionCount(stuId);
    }


    public List<noticesDto> findNoticesByStuId(int stuId,int offset,int limit) {
        //还要返回是否已阅读
        List<noticesDto> list=mapper.selectByStuId(stuId,offset,limit);
        for (int i=0;i<list.size();i++){
            stu_notification sn=stuNotificationService.getById(stuId,list.get(i).getId());
            list.get(i).setRead(sn.getReadStatus());
        }
        return list;
    }

    public int getNoticesCount(int stuId) {
        return mapper.getNoticesCount(stuId);
    }

    public boolean addNotices(notification notices) {
        int n=mapper.insertAndGetId(notices);
        if (n==1)return true;
        return false;
    }

    public List<noticesDto> getViewRecently(int stuId,int offset,int limit) {
        List result=mapper.selectBYTime(stuId,offset,limit);
        return result;
    }
    public int getViewRecentlyCount(int stuId) {
        return mapper.getRecentlyViewedCount(stuId);
    }

    public boolean addCollect(int stuId, int noticeId) {
        stu_notification record= stuNotificationService.getById(stuId,noticeId);
        if (record==null)return false;
        record.setCollect(true);
        return true;
    }

    public boolean cancelCollect(int stuId, int noticeId) {
        stu_notification record= stuNotificationService.getById(stuId,noticeId);
        if (record==null)return false;
        record.setCollect(false);
        return true;
    }
}
