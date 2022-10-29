package com.tian.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 延迟消息队列实现方式
 * 比如说：一个订单，如果在半小时之内没有支付，那么这个订单将会作废。
 * 言外之意就是，订单创建后半小时的时候，需要把订单状态设置为已作废
 */
//@Component
public class CancelOrderSender {
    /*private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderSender.class);
    @Resource
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(Long orderId, final long delayTimes){
        //给延迟队列发送消息
        rabbitTemplate.convertAndSend(MQConstants.DIRECT_EXCHANGE, MQConstants.CANCEL_ROUT_KEY, orderId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        });
        LOGGER.info("send orderId:{}",orderId);
    }*/
}
