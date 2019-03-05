package com.IMBA.dao;

import com.IMBA.entity.course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface courseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(course record);

    int insertSelective(course record);

    course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(course record);

    int updateByPrimaryKey(course record);

    int insertAndGetId(course record);

    course selectByCouseId( @Param("stuId") Integer stuId, @Param("course_id")Integer id);



}