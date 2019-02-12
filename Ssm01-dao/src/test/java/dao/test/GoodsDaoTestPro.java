package dao.test;

import com.IMBA.dao.GoodsDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//@TransactionConfiguration(defaultRollback = true)  //被弃用
@Rollback(true)  //是否回滚
public class GoodsDaoTestPro {

    @Autowired
    GoodsDao dao;

    @Test
    public void testGetAll(){
        System.out.println(dao.getAll(null));
    }

    @Test
    public void testDeleteByIds(){
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(5);
        int rows=dao.deleteByIds(ids);
        Assert.assertEquals(3,rows);
    }
}
