package com.cobra.seckill.dao;

import com.cobra.seckill.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2018/12/24 10:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        /*
         * 第一次：insertCount:1
         * 第二次：insertCount:0
         */
        long seckill = 1001L;
        long userPhone = 15869137159L;
        int insertCount = successKilledDao.insertSuccessKilled(seckill,userPhone);
        System.out.println("insertCount:"+insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        /*
            SuccessKissed{seckillId=1000, userPhone=15869137159, state=-1, createTime=Mon Dec 24 10:48:37 CST 2018,
            seckill=Seckill{seckillId=1000, name='1000元秒杀iPhoneX', number=94, startTime=Mon Dec 24 04:43:10 CST 2018,
            endTime=Mon Dec 24 10:00:00 CST 2018, createTime=Sun Dec 23 22:57:59 CST 2018}}
         */
        long seckill = 1001L;
        long userPhone = 15869137159L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckill,userPhone);
        System.out.println(successKilled);
    }
}