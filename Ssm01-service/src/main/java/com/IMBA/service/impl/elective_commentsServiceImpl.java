package com.IMBA.service.impl;

import com.IMBA.dao.elective_commentsMapper;
import com.IMBA.dto.electiveCommentsDto;
import com.IMBA.entity.elective_comments;
import com.IMBA.service.elective_commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*@Service("elective_commentsService")*/
public class elective_commentsServiceImpl implements elective_commentsService {
    @Autowired
    elective_commentsMapper electiveCommentsMapper;
    public List<electiveCommentsDto> getComments(int id) {
        List list=electiveCommentsMapper.selectCommentsById(id);
        return list;
    }

    public boolean addComment(int electiveId, int stuId, Date date, String content) {
        elective_comments ec=new elective_comments();
        ec.setCommentContent(content);
        ec.setCommentTime(date);
        ec.setElectiveId(electiveId);
        ec.setStudentId(stuId);
        int n=electiveCommentsMapper.insertAndGetId(ec);
        if(n==1)return true;
        return false;
    }
}
