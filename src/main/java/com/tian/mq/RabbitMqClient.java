package com.tian.mq;

import com.tian.entity.DrugInfoOperationLog;
import com.tian.entity.User;
import com.tian.enums.QueueEnum;
import com.tian.mq.message.PrescriptionPricingMsg;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 消息发送（生产者）
 * @createTime 2022年10月15日 07:44
 */
@Component
public class RabbitMqClient {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * direct交换机为直连模式交换机
     * 根据消息携带的路由键将消息投递给对应队列
     */

    /**
     * 登录日志
     *
     * @param message
     */
    public void loginLog(User message) {
        rabbitTemplate.convertAndSend(QueueEnum.LOGIN_LOG.getExchange(), QueueEnum.LOGIN_LOG.getRouteKey(), message);
    }

    /**
     * 系统 添加医生 操作日志
     */
    public void doctorAddLog(String message) {
        rabbitTemplate.convertAndSend(QueueEnum.DOCTOR_ADD_LOG.getExchange(), QueueEnum.DOCTOR_ADD_LOG.getRouteKey(), message);
    }

    /**
     * 还可以做很多类似的日志记录
     *
     * 比如：医生开药 谁给病人开了什么药 药量等信息 便于后期可查询 可统计
     */
    /**
     * 系统 添加医生 操作日志
     */
    public void sendPrescriptionPricing(PrescriptionPricingMsg message) {
        rabbitTemplate.convertAndSend(QueueEnum.PRICING_LOG.getExchange(), QueueEnum.PRICING_LOG.getRouteKey(), message);
    }

    public void sendDrugInfoOperationLog(DrugInfoOperationLog message) {
        rabbitTemplate.convertAndSend(QueueEnum.DRUG_INFO_OPERATION_LOG.getExchange(), QueueEnum.DRUG_INFO_OPERATION_LOG.getRouteKey(), message);
    }

}
