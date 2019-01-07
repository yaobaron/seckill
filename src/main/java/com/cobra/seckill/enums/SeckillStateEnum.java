package com.cobra.seckill.enums;

/**
 * @Author: Baron
 * @Description: 使用枚举表述常量数据字段
 * @Date: Created in 2018/12/24 13:26
 */
public enum SeckillStateEnum {

    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;

    private String steteInfo;

    SeckillStateEnum(int state, String steteInfo) {
        this.state = state;
        this.steteInfo = steteInfo;
    }

    public int getState() {
        return state;
    }

    public String getSteteInfo() {
        return steteInfo;
    }

    public static SeckillStateEnum stateof (int index) {
        for ( SeckillStateEnum state: values()) {
            if (state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
