package com.tian.enums;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月25日 08:58
 * 支付状态
 */
public enum PaymentStatusEnum {
    /**
     * 初始状态（未支付）
     */
    INIT(0, "初始状态"),
    /**
     * 支付完成
     */
    SUCCESS(1, "支付完成"),
    /**
     * 支付失败（超时未支付、余额不够）
     */
    FAILED(2, "支付失败");
    private int code;
    private String desc;


    PaymentStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
