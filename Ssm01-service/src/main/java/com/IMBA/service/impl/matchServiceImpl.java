package com.IMBA.service.impl;

import com.IMBA.dao.matchMapper;
import com.IMBA.entity.match;
import com.IMBA.service.matchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("matchService")
public class matchServiceImpl implements matchService {
    @Autowired
    matchMapper matchmapper;
    public List<match> getMatchByType(int type, int offset, int num) {
        List<match> result=matchmapper.selectByType(type,offset,num);
        return result;
    }

    public match getMatchDetail(int id) {
        match m=matchmapper.selectByPrimaryKey(id);
        return m;
    }

    public int getCount(int type) {
        return matchmapper.getCount(type);
    }
}
