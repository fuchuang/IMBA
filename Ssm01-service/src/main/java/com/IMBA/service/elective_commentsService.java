package com.IMBA.service;

import com.IMBA.dto.electiveCommentsDto;

import java.util.Date;
import java.util.List;

public interface elective_commentsService {

    //返回某选修评论列表
    List<electiveCommentsDto> getComments(int id);

    //添加选修评论
    boolean addComment(int electiveId, int stuId, Date date,String content);
}
