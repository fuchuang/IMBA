package com.IMBA.dao;

import com.IMBA.entity.stu_courseKey;
import com.IMBA.entity.course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface stu_courseMapper {
    int deleteByPrimaryKey(stu_courseKey key);

    int insert(stu_courseKey record);

    int insertSelective(stu_courseKey record);

    List<course> findCoursesOfWeek(@Param("stuId") Integer stuId,
                                   @Param("year") String year,
                                   @Param("week") Byte week);
}