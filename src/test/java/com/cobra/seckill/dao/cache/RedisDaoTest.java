package com.cobra.seckill.dao.cache;

import com.cobra.seckill.dao.SeckillDao;
import com.cobra.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2018/12/25 22:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

    private long id = 1002;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void getSeckill() throws Exception {
        Seckill seckill = redisDao.getSeckill(id);
        System.out.println("=================="+seckill);
        if (seckill==null) {
            System.out.println("访问数据库！！！！！！！！！！！！！！");
            seckill = seckillDao.queryById(id);
            if (seckill!=null) {
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                seckill =redisDao.getSeckill(id);
            }
        }
    }

}