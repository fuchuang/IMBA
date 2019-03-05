package com.IMBA.dao;

import com.IMBA.dto.examResultDto;
import com.IMBA.entity.examination;
import com.IMBA.entity.examinationKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface examinationMapper {
    int deleteByPrimaryKey(examinationKey key);

    int insert(examination record);

    int insertSelective(examination record);

    examination selectByPrimaryKey(examinationKey key);

    int updateByPrimaryKeySelective(examination record);

    int updateByPrimaryKey(examination record);

    List<examResultDto> selectByYear(@Param("year") String year,
                                     @Param("stuId") Integer stuId);
}