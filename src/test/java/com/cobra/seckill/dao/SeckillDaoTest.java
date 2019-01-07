package com.cobra.seckill.dao;

import com.cobra.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() {
        long id =1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        /**
         * org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [arg1, arg0, param1, param2]
         */
        //List<Seckill> queryAll(int offset, int limit);
        //java没有保存形参的记录queryAll(int offset, int limit)=》queryAll(arg0,arg1s)
        //List<Seckill> queryAll(@Param("offset") int offset, @Param("limit")  int limit);
        List<Seckill> list = seckillDao.queryAll(0,100);
        for (Seckill seckill:list) {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() {
        Date date = new Date();
        int num = seckillDao.reduceNumber(1000L,date);
        System.out.println(num);
    }


}