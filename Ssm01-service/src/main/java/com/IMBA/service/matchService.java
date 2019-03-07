package com.IMBA.service;

import com.IMBA.entity.match;

import java.util.List;

public interface matchService {

    List<match> getMatchByType(int type,int offset,int num);

    match getMatchDetail(int id);

    int getCount(int type);

}
