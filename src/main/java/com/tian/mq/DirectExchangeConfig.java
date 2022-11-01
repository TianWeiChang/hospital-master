package com.tian.mq;

import com.tian.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 直连模式
 * @createTime 2022年10月15日 08:51
 */
@Configuration
public class DirectExchangeConfig {

    @Bean
    public Queue loginLogQueue() {
        return new Queue(QueueEnum.LOGIN_LOG.getQueueName(), true);
    }

    @Bean
    public DirectExchange loginLogDirectExchange() {
        return new DirectExchange(QueueEnum.LOGIN_LOG.getExchange(), true, false);
    }
    @Bean
    public Binding bindingDirectExchange4LoginLog(Queue loginLogQueue, DirectExchange loginLogDirectExchange) {
        return BindingBuilder.bind(loginLogQueue).to(loginLogDirectExchange).with(QueueEnum.LOGIN_LOG.getRouteKey());
    }


    @Bean
    public Queue doctorAddLogQueue() {
        return new Queue(QueueEnum.DOCTOR_ADD_LOG.getQueueName(), true);
    }

    @Bean
    public DirectExchange doctorAddLogDirectExchange() {
        return new DirectExchange(QueueEnum.DOCTOR_ADD_LOG.getExchange(), true, false);
    }
    @Bean
    public Binding bindingDirectExchange4DoctorAddLog(Queue doctorAddLogQueue, DirectExchange doctorAddLogDirectExchange) {
        return BindingBuilder.bind(doctorAddLogQueue).to(doctorAddLogDirectExchange).with(QueueEnum.DOCTOR_ADD_LOG.getRouteKey());
    }

    @Bean
    public Queue prescriptionPricingQueue() {
        return new Queue(QueueEnum.PRICING_LOG.getQueueName(), true);
    }

    @Bean
    public DirectExchange prescriptionPricingAddLogDirectExchange() {
        return new DirectExchange(QueueEnum.PRICING_LOG.getExchange(), true, false);
    }
    @Bean
    public Binding bindingDirectExchange4PrescriptionPricingAddLog(Queue prescriptionPricingQueue, DirectExchange prescriptionPricingAddLogDirectExchange) {
        return BindingBuilder.bind(prescriptionPricingQueue).to(prescriptionPricingAddLogDirectExchange).with(QueueEnum.PRICING_LOG.getRouteKey());
    }
}