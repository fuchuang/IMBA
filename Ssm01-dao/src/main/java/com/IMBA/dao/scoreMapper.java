package com.IMBA.dao;

import com.IMBA.dto.courseScoresDto;
import com.IMBA.entity.score;
import com.IMBA.entity.scoreKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface scoreMapper {
    int deleteByPrimaryKey(scoreKey key);

    int insert(score record);

    int insertSelective(score record);

    score selectByPrimaryKey(scoreKey key);

    int updateByPrimaryKeySelective(score record);

    int updateByPrimaryKey(score record);

    List<courseScoresDto> selectCourseScores(@Param("stuId")Integer stuId,
                                             @Param("year" )String year);

    List<courseScoresDto> selectAllCourseScore(Integer stuId);

    List<Integer> selectStudentsIdByMajor(Integer stuId);
}