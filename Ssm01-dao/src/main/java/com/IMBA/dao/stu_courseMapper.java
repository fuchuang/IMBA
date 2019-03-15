package com.IMBA.dao;

import com.IMBA.dto.stuCourseDto;
import com.IMBA.entity.course;
import com.IMBA.entity.stu_courseKey;
import com.IMBA.model.studentregistermodel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface stu_courseMapper {
    int findcount(int courseid);
    List<studentregistermodel>findstudentregistermodel(int courseinfoid,int day_of_week,int week_of_semester,int lesson_of_day);





    List<course> findCoursesOfWeek(@Param("stuId") Integer stuId,
                                   @Param("year") String year,
                                   @Param("week") Byte week);

    List<stuCourseDto> findCoursesList(Integer stuId);

    List<Integer> selectMajorIdByCourseId(Integer courseId);

    List<course> findCoursesOfSemester(@Param("stuId") Integer stuId,
                                       @Param("year") String year);

    int deleteById(Integer id);

    stu_courseKey selectById(Integer id);




    int deleteByPrimaryKey(stu_courseKey key);

    int insert(stu_courseKey record);

    int insertSelective(stu_courseKey record);
}