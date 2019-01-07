package com.cobra.seckill.service;

import com.cobra.seckill.dto.Exposer;
import com.cobra.seckill.dto.SeckillExecution;
import com.cobra.seckill.entity.Seckill;
import com.cobra.seckill.exception.SeckillException;

import java.util.List;

/**
 * @Author: Baron
 * @Description: 业务接口：站在“使用者”角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * @Date: Created in 2018/12/24 11:12
 */
public interface SeckillService {

    /**
     * 查询所有秒杀产品记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀产品记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     */
    SeckillExecution excuteSeckill(long seckillId, long userPhone, String MD5)
            throws SeckillException, RuntimeException, SeckillException;

}
