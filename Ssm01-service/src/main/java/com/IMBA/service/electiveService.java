package com.IMBA.service;

import com.IMBA.dto.electiveResultDto;
import com.IMBA.entity.elective;

import java.util.Date;
import java.util.List;

public interface electiveService {
    // 查找学生选课收藏列表
    List<electiveResultDto> findCollectionsByStuId(int stuId);

    List<electiveResultDto> findElectiveByType(int stuId,String type);

    //通过关键字检索选课表
    List<electiveResultDto> searchByKeyWord(int stuId,String keyWord);
}
