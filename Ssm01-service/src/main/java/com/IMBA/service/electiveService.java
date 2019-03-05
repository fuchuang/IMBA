package com.IMBA.service;

import com.IMBA.dto.electiveResultDto;
import com.IMBA.entity.elective;

import java.util.Date;
import java.util.List;

public interface electiveService {
    // 查找学生选课收藏列表
    List<electiveResultDto> findCollectionsByStuId(int stuId);

    List<electiveResultDto> findElectiveByType(int stuId,String type);

    //通过关键字检索选课表
    List<electiveResultDto> searchByKeyWord(int stuId,String keyWord);

    //点赞选修
    boolean addLike(int stuId,int electiveId);

    //取消点赞
    boolean cancelLike(int stuId,int electiveId);

    //收藏选修
    boolean addCollect(int stuId,int electiveId,Date date);

    //取消收藏选修
    boolean cancelCollect(int stuId,int electiveId);
}
