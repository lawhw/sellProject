package com.zzw.order.controller;

import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.po.order.OrderMaster;
import com.zzw.order.message.StreamClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/22 19:54
 * @description：mq消息发送端
 * @modified By：
 */
@RestController
@AllArgsConstructor
public class SendMessageController {
    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void process(){
//        streamClient.output().
//                send(MessageBuilder.withPayload("now"+new Date()).build() );
//    }

    /**
     * 发送orderDto
     */
    @GetMapping("/sendMessage")
    public void process(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345");
        streamClient.output().
                send(MessageBuilder.withPayload(orderMaster).build());
    }
}
