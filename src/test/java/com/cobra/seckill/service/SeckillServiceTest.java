package com.cobra.seckill.service;

import com.cobra.seckill.dto.Exposer;
import com.cobra.seckill.dto.SeckillExecution;
import com.cobra.seckill.entity.Seckill;
import com.cobra.seckill.exception.RepeatKillException;
import com.cobra.seckill.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2018/12/24 14:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"" +
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        /*
            14:49:18.529 [main] INFO  c.c.s.service.SeckillServiceTest -
            list[
                Seckill{seckillId=1000, name='1000元秒杀iPhoneX', number=94, startTime=Mon Dec 24 04:43:10 CST 2018, endTime=Mon Dec 24 10:00:00 CST 2018, createTime=Sun Dec 23 22:57:59 CST 2018},
                Seckill{seckillId=1001, name='500元秒杀iPad4', number=200, startTime=Mon Dec 24 00:00:00 CST 2018, endTime=Mon Dec 24 01:00:00 CST 2018, createTime=Sun Dec 23 22:57:59 CST 2018},
                Seckill{seckillId=1002, name='1000元秒杀华为p20', number=300, startTime=Mon Dec 24 00:00:00 CST 2018, endTime=Mon Dec 24 01:00:00 CST 2018, createTime=Sun Dec 23 22:57:59 CST 2018},
                 Seckill{seckillId=1003, name='800元秒杀小米8', number=400, startTime=Mon Dec 24 00:00:00 CST 2018, endTime=Mon Dec 24 01:00:00 CST 2018, createTime=Sun Dec 23 22:57:59 CST 2018}]
         */
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list{}",list);
    }

    @Test
    public void getById() {
        /*
            14:51:42.783 [main] INFO  c.c.s.service.SeckillServiceTest -
            seckill=
                Seckill{seckillId=1000, name='1000元秒杀iPhoneX', number=94, startTime=Mon Dec 24 04:43:10 CST 2018, endTime=Mon Dec 24 10:00:00 CST 2018, createTime=Sun Dec 23 22:57:59 CST 2018}
         */
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        /*
            14:58:36.167 [main] INFO  c.c.s.service.SeckillServiceTest - exposer=Exposer{exposed=false, md5='null', seckillId=1000, now=1545634716166, start=1545597790000, end=1545616800000}
         */
        /*long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);*/

        /*
            15:00:52.013 [main] INFO  c.c.s.service.SeckillServiceTest - exposer1=Exposer{exposed=true, md5='2e00b2b7fbf7e3952331d44d34d91780', seckillId=1001, now=0, start=0, end=0}
         */
        long id1 = 1001;
        Exposer exposer1 = seckillService.exportSeckillUrl(id1);
        logger.info("exposer1={}",exposer1);

    }

    @Test
    public void excuteSeckill() {
        long id = 1001;
        long userPhone = 15869137152L;
        String md5 = "2e00b2b7fbf7e3952331d44d34d91780";
        try {
            SeckillExecution seckillExecution = seckillService.excuteSeckill(id,userPhone,md5);
            logger.info("seckillExecution={}",seckillExecution);
        }catch (RepeatKillException e){
            logger.error(e.getMessage());
        }catch (SeckillCloseException e1) {
            logger.error(e1.getMessage());
        }

        /*
             因：
             if (md5==null || md5.equals(getMD5(seckillId))) {
                throw new SeckillException("seckill data rewrite");
            }
            导致：
            com.cobra.seckill.exception.SeckillException: seckill data rewrite
            改为：
            if (md5==null || !md5.equals(getMD5(seckillId))) {
                throw new SeckillException("seckill data rewrite");
            }
         */

        /*
            15:18:42.483 [main] INFO  c.c.s.service.SeckillServiceTest - seckillExecution=SeckillExecution{seckillId=1001, state=1, stateInfo='秒杀成功',
            successKilled=SuccessKissed{seckillId=1001, userPhone=15869137152, state=0, createTime=Mon Dec 24 15:18:42 CST 2018,
            seckill=Seckill{seckillId=1001, name='500元秒杀iPad4', number=197, startTime=Mon Dec 24 15:18:42 CST 2018, endTime=Mon Dec 24 23:00:00 CST 2018, createTime=Sun Dec 23 22:57:59 CST 2018}}}
         */

    }

    /**
     * 集成测试代码逻辑，可重复执行
     */
    @Test
    public void testSeckillLogic() {

        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}",exposer);
            long userPhone = 15869137153L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.excuteSeckill(id,userPhone,md5);
                logger.info("seckillExecution={}",seckillExecution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseException e1) {
                logger.error(e1.getMessage());
            }
        } else {
            //警告秒杀未开始
            logger.info("exposer={}",exposer);
        }

    }
}