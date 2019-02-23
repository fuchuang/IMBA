package com.IMBA.dao;

import com.IMBA.entity.bullet_comments;
import com.IMBA.entity.bullet_commentsKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface bullet_commentsMapper {
    int deleteByPrimaryKey(bullet_commentsKey key);

    int insert(bullet_comments record);

    int insertSelective(bullet_comments record);

    bullet_comments selectByPrimaryKey(bullet_commentsKey key);

    int updateByPrimaryKeySelective(bullet_comments record);

    int updateByPrimaryKey(bullet_comments record);

    List<bullet_comments> selectByWeek(@Param("majorId") Integer majorId,@Param("year") String year,@Param("week") Byte week);
}