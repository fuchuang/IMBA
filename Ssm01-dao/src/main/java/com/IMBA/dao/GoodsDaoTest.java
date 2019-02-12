package com.IMBA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class GoodsDaoTest {
    @Autowired
    GoodsDao dao;

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodsDao dao=ctx.getBean(GoodsDao.class);
        System.out.println(dao.getAll("特产"));
    }
}
