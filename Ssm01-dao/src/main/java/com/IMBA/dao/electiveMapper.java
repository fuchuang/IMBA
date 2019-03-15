package com.IMBA.dao;

import com.IMBA.dto.electiveResultDto;
import com.IMBA.entity.elective;
import com.IMBA.entity.electiveKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface electiveMapper {

    List<electiveResultDto> selectCollection(Integer stuId);

    List<electiveResultDto> selectByType(String type);

    List<electiveResultDto> selectByKeyWord(@Param("keyWord") String keyWord,
                                            @Param("stuId") Integer stuId);




    int deleteByPrimaryKey(electiveKey key);

    int insert(elective record);

    int insertSelective(elective record);

    elective selectByPrimaryKey(electiveKey key);

    int updateByPrimaryKeySelective(elective record);

    int updateByPrimaryKey(elective record);
}