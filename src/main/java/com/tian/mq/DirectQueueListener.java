package com.tian.mq;

import com.tian.entity.PrescriptionPricing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 直连交换机的监听器
 * @createTime 2022年10月15日 08:53
 */
@Slf4j
@Component
public class DirectQueueListener {

    /**
     *  可以创建一个表，用来记录日志信息
     *  再创建对应的mapper
     */

    @RabbitHandler
    @RabbitListener(queues = MqConstants.LOGIN_LOG)
    public void loginLog(String testMessage) {
        /**
         * 把日志信息录入到相应的数据库表中
         */
        log.info("医生【登录】日志记录  :{} " , testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = MqConstants.DOCTOR_ADD_LOG)
    public void doctorAdd(String testMessage) {
        /**
         * 把日志信息录入到相应的数据库表中
         */
        log.info("系统【添加医生】日志记录 : {}", testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = MqConstants.DOCTOR_ADD_LOG)
    public void doctorAdd(Message<PrescriptionPricing> testMessage) {
        log.info("系统【添加医生】日志记录 : {}", testMessage);
    }
}
