package com.tian.enums;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月13日 00:20
 * <p>
 * 交易状态
 */
public enum PayStatusEnum {
    /**
     * 挂号完成，但是没有发起支付
     */
    INIT(0, "初始状态"),
    /**
     * 支付单创建成功
     */
    WAIT_BUYER_PAY(1, "交易创建，等待买家付款。"),
    /**
     * 支付成功
     */
    TRADE_SUCCESS(2, "交易支付成功。"),
    /**
     * 交易结束
     */
    TRADE_FINISHED(3, "交易结束，不可退款。"),
    /**
     * 支付失败
     */
    TRADE_CLOSED(4, "未付款交易超时关闭，或支付完成后全额退款");

    private int code;
    private String des;


    PayStatusEnum(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public static PayStatusEnum valueOfName(String name) {
        for (PayStatusEnum payStatusEnum : PayStatusEnum.values()) {
            if (payStatusEnum.name().equals(name)) {
                return payStatusEnum;
            }
        }
        return null;
    }
}
