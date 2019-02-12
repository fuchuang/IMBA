package dao.test;


import com.IMBA.dao.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//指定bean注入的配置文件
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
//@TransactionConfiguration(defaultRollback = true)
@Rollback(true)
public class GoodsDaoTest {

    @Autowired
    GoodsDao dao;

    @Test
    public void testGetAll(){
        System.out.println(dao.getAll(null));
    }

    @Test
    public void testDeletes(){
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        System.out.println(dao.deleteByIds(ids));
    }

}
