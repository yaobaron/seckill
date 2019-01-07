package com.cobra.seckill.exception;

/**
 * @Author: Baron
 * @Description: 重复秒杀异常（运行期异常）
 * @Date: Created in 2018/12/24 12:21
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
