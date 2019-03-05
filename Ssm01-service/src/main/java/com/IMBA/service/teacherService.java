package com.IMBA.service;

import com.IMBA.dto.teachInfoDto;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

public interface teacherService {

    //查询教师列表
    List<teachInfoDto> getTeachersInfo(int stuId);

    //点赞教师
    boolean addLikes(int stuId,int teacherId);

    //取消点赞
    boolean cancelLikes(int stuId,int teacherId);
}
