package com.IMBA.dao;

import com.IMBA.entity.elective_comments;
import com.IMBA.entity.elective_commentsKey;

public interface elective_commentsMapper {
    int deleteByPrimaryKey(elective_commentsKey key);

    int insert(elective_comments record);

    int insertSelective(elective_comments record);

    elective_comments selectByPrimaryKey(elective_commentsKey key);

    int updateByPrimaryKeySelective(elective_comments record);

    int updateByPrimaryKey(elective_comments record);
}