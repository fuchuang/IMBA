package com.IMBA.service.impl;

import com.IMBA.dao.elective_LikesMapper;
import com.IMBA.entity.electiveLikes;
import com.IMBA.service.electiveLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
@Service("electiveLikeService")*/
public class electiveLikeServiceImpl implements electiveLikeService {
    @Autowired
    elective_LikesMapper electiveLikesmapper;

    public boolean isLiked(int stuId, int electiveId) {
        electiveLikes el=new electiveLikes();
        el.setElectiveId(electiveId);
        el.setStudentId(stuId);
        electiveLikes result=electiveLikesmapper.selectByPrimaryKey(el);
        if (result!=null){
            return true;
        }
        return false;
    }

    public boolean addLkie(int stuId, int electiveId) {
        electiveLikes record=new electiveLikes();
        record.setStudentId(stuId);
        record.setElectiveId(electiveId);
        int n=electiveLikesmapper.insert(record);
        if (n==1){
            return true;
        }
        return false;
    }

    public boolean deleteLike(int stuId, int electiveId) {
        electiveLikes record=new electiveLikes();
        record.setElectiveId(electiveId);
        record.setStudentId(stuId);
        int n=electiveLikesmapper.deleteByPrimaryKey(record);
        if (n==1){
            return true;
        }
        return false;
    }
}
