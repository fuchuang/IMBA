package com.IMBA.service;

import com.IMBA.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> queryGoodsByName(String name);

    int deletes(List<Integer> ids);
}
