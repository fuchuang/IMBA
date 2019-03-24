package com.IMBA.service.impl;

import com.IMBA.dao.elective_collectionsMapper;
import com.IMBA.entity.elective_collections;
import com.IMBA.entity.elective_collectionsKey;
import com.IMBA.service.elective_collectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/*@Service("elective_collectionsService")*/
public class elective_collectionsServiceImpl implements elective_collectionsService {
    @Autowired
    elective_collectionsMapper electiveCollectionsMapper;
    public boolean collectElective(int stuId, int electiveId , Date addTime) {
        elective_collections record=new elective_collections();
        record.setCollectionTime(addTime);
        record.setElectiveId(electiveId);
        record.setStudentId(stuId);
        int n=electiveCollectionsMapper.insertSelective(record);
        if (n==1){
            return true;
        }
        return false;
    }

    public boolean cancelCollect(int stuId, int electiveId) {
        elective_collections record=new elective_collections();
        record.setStudentId(stuId);
        record.setElectiveId(electiveId);
        int n=electiveCollectionsMapper.deleteByPrimaryKey(record);
        if (n==1){
            return true;
        }
        return false;
    }

    public boolean isCollected(int stuId, int electiveId) {
        elective_collectionsKey eckey=new elective_collectionsKey();
        eckey.setElectiveId(electiveId);
        eckey.setStudentId(stuId);
        elective_collections ec=electiveCollectionsMapper.selectByPrimaryKey(eckey);
        if (ec!=null){
            return true;
        }
        return false;
    }
}
