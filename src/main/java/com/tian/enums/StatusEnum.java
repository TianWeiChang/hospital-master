package com.tian.enums;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 常规状态枚举
 * @createTime 2022年10月19日 16:24
 */
public enum StatusEnum {
    normal(0),
    abnormal(1);
    private int code;

    StatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
