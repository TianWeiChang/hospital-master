package com.tian.enums;

import com.tian.mq.MqConstants;
import lombok.Getter;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 消息队列枚举类
 * @createTime 2022年10月15日 10:08
 */
@Getter
public enum QueueEnum {
    /**
     * 登录日志
     */
    LOGIN_LOG(MqConstants.LOGIN_LOG, MqConstants.LOGIN_LOG, MqConstants.LOGIN_LOG),
    /**
     * 添加医生日志
     */
    DOCTOR_ADD_LOG(MqConstants.DOCTOR_ADD_LOG, MqConstants.DOCTOR_ADD_LOG, MqConstants.DOCTOR_ADD_LOG),
    /**
     * 医生给病人开处方
     */
    PRICING_LOG(MqConstants.PRICING_LOG, MqConstants.PRICING_LOG, MqConstants.PRICING_LOG);

    /**
     * 交换名称
     */
    private final String exchange;
    /**
     * 队列名称
     */
    private final String queueName;
    /**
     * 路由键
     */
    private final String routeKey;

    QueueEnum(String exchange, String queueName, String routeKey) {
        this.exchange = exchange;
        this.queueName = queueName;
        this.routeKey = routeKey;
    }
}
