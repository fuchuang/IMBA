package com.IMBA.service;

import java.util.Date;

public interface elective_collectionsService {
    //添加该学生的选课收藏
    boolean collectElective(int stuId,int electiveId, Date addTime);

    //取消收藏选课
    boolean cancelCollect(int stuId,int electiveId);

    //查询学生是否已收藏该选课
    boolean isCollected(int stuId,int electiveId);
}
