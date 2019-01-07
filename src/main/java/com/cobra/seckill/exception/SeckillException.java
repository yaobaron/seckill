package com.cobra.seckill.exception;

/**
 * @Author: Baron
 * @Description: 秒杀相关业务异常
 * @Date: Created in 2018/12/24 12:27
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
