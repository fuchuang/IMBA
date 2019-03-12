package com.IMBA.dao;

import com.IMBA.entity.course_info;
import com.IMBA.model.coursemodel;

import java.util.List;

public interface course_infoMapper {


    List<coursemodel> findCouseMsg(int student_id, String year);
    List<coursemodel>findCouseMsgbyteacherid(int teacher,String year);
    int findcourse_hourbycourid(int courseid);
    //查找课程数目
    int findcount();





    int deleteByPrimaryKey(Integer id);

    int insert(course_info record);

    int insertSelective(course_info record);

    course_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(course_info record);

    int updateByPrimaryKey(course_info record);
}