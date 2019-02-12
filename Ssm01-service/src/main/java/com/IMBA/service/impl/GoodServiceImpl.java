package com.IMBA.service.impl;

import com.IMBA.dao.GoodsDao;
import com.IMBA.entity.Goods;
import com.IMBA.service.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> queryGoodsByName(String name) {
        if(StringUtils.isEmpty(name)){
            name=null;
        }
        return goodsDao.getAll(name);
    }

    @Override
    public int deletes(List<Integer> ids) {
        if(ids==null||ids.size()<=0) {
            return 0;
        }
        return goodsDao.deleteByIds(ids);
    }
}
