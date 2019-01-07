package com.cobra.seckill.exception;

/**
 * @Author: Baron
 * @Description: 秒杀关闭异常
 * @Date: Created in 2018/12/24 12:26
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
