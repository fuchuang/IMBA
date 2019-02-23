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

    //TODO 实现查询的sql语句
    List<course> findCoursesOfDay(@Param("stuId") int stuId,@Param("year") String year,@Param("week") int week,@Param("day") int day);

    //TODO 通过id查找课程
    course findCourseById(Integer id);

}