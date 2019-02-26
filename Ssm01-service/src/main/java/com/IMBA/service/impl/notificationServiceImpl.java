package com.IMBA.service.impl;

import com.IMBA.dao.notificationMapper;
import com.IMBA.dto.noticesDto;
import com.IMBA.entity.notification;
import com.IMBA.service.notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("notificationService")
public class notificationServiceImpl implements notificationService {
    @Autowired
    notificationMapper mapper;

    public List<noticesDto> findCollectionsByStuId(int stuId) {
        List<noticesDto> list=mapper.selectCollection(stuId);
        return list;
    }

    public notification noticesDetail(int id) {
        notification notice=mapper.selectById(id);
        return notice;
    }

    public List<noticesDto> findNoticesByStuId(int stuId) {
        List list=mapper.selectByStuId(stuId);
        return list;
    }

    public boolean addNotices(notification notices) {
        int n=mapper.insertAndGetId(notices);
        System.out.println("insertAndGetId--"+n);
        return true;
    }
}
