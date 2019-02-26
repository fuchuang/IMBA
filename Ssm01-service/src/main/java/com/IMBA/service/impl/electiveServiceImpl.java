package com.IMBA.service.impl;

import com.IMBA.dao.electiveMapper;
import com.IMBA.entity.elective;
import com.IMBA.service.electiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("electiveService")
public class electiveServiceImpl implements electiveService {
    @Autowired
    electiveMapper electivemapper;

    public List<elective> findCollectionsByStuId(int stuId) {
        List<elective> list=electivemapper.selectCollection(stuId);
        return list;
    }
}
