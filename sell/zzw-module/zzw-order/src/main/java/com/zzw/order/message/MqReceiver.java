package com.zzw.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/21 19:32
 * @description：接收Mq消息类
 * @modified By：
 */
@Slf4j
@Component
public class MqReceiver {
    // 1.   @RabbitListener(queues = "myQueue")
    // 2.   自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
     @RabbitListener(bindings = @QueueBinding(
             value = @Queue("myQueue"),
             exchange = @Exchange("myExchange")
     ))
    private void process(String message){
        log.info("MQ接收：{}",message);
    }

    /**
     * 数码供应商
     * @param message
     */

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            exchange = @Exchange("myOrder"),
            key = "computer"
    ))
    private void processComputer(String message){
        log.info("computerMQ接收：{}",message);
    }

    /**
     * 水果供应商
     * @param message
     */

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            exchange = @Exchange("myOrder"),
            key = "fruit"
    ))
    private void processFruit (String message){
        log.info("fruit MQ接收：{}",message);
    }
}
