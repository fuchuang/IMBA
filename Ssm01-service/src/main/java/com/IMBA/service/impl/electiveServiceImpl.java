package com.IMBA.service.impl;

import com.IMBA.dao.electiveMapper;
import com.IMBA.dto.electiveResultDto;
import com.IMBA.entity.elective;
import com.IMBA.service.electiveLikeService;
import com.IMBA.service.electiveService;
import com.IMBA.service.elective_collectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*@Service("electiveService")*/
public class electiveServiceImpl implements electiveService {
    @Autowired
    electiveMapper electivemapper;
    @Autowired
    elective_collectionsService electiveCollectionsService;
    @Autowired
    electiveLikeService electiveLikeservice;


    public List<electiveResultDto> findCollectionsByStuId(int stuId) {
        List<electiveResultDto> list=electivemapper.selectCollection(stuId);
        for (electiveResultDto record:list){
            record.setCollected(true);
            boolean isLiked=electiveLikeservice.isLiked(stuId,record.getId());
            record.setLike(isLiked);
        }
        return list;
    }

    public List<electiveResultDto> findElectiveByType(int stuId,String type) {
        List<electiveResultDto> result=electivemapper.selectByType(type);
        for (electiveResultDto record:result){
            boolean isCollect=electiveCollectionsService.isCollected(stuId,record.getId());
            record.setCollected(isCollect);
            boolean isLiked=electiveLikeservice.isLiked(stuId,record.getId());
            record.setLike(isLiked);
        }
        return result;
    }

    public List<electiveResultDto> searchByKeyWord(int stuId,String keyWord) {
        String key="%"+keyWord+"%";
        List<electiveResultDto> result=electivemapper.selectByKeyWord(key,stuId);
        //确定学生是否收藏选课和点赞选课
        for (int i=0;i<result.size();i++){
            electiveResultDto e=result.get(i);
            boolean isCollect=electiveCollectionsService.isCollected(stuId,e.getId());
            e.setCollected(isCollect);
            boolean isLiked=electiveLikeservice.isLiked(stuId,e.getId());
            e.setLike(isLiked);

        }
        return result;
    }

    public boolean addLike(int stuId, int electiveId) {
        boolean result=electiveLikeservice.addLkie(stuId,electiveId);
        if (result)return true;
        return false;
    }

    public boolean cancelLike(int stuId, int electiveId) {
        boolean result= electiveLikeservice.deleteLike(stuId,electiveId);
        if (result)return true;
        return false;
    }

    public boolean addCollect(int stuId, int electiveId, Date date) {
        boolean result=electiveCollectionsService.collectElective(stuId,electiveId,date);
        if (result)return true;
        return false;
    }

    public boolean cancelCollect(int stuId, int electiveId) {
        boolean result=electiveCollectionsService.cancelCollect(stuId,electiveId);
        if (result)return true;
        return false;
    }

    public boolean addLike(int id) {
        elective record=new elective();
        record.addLikesNumber();
        record.setId(id);
        int n=electivemapper.updateByPrimaryKeySelective(record);
        if (n==1){
            return true;
        }
        return false;
    }
}
