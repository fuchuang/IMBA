package com.IMBA.dao;

import com.IMBA.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /**获得所有商品*/
    public List<Goods> getAll(@Param("name") String name);

    /**多删除*/
    int deleteByIds(@Param("ids") List<Integer> ids);
}
