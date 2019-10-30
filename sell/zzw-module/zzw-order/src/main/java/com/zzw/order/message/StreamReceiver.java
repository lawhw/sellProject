package com.zzw.order.message;

import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.po.order.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/22 19:43
 * @description：接收端
 * @modified By：
 */
@Component
@EnableBinding(value = {StreamClient.class})
@Slf4j
public class StreamReceiver {

//    @StreamListener(value = "myMessageOut")
//    public void process(String message){
//        log.info("StreamReceiver:{}",message);
//    }


    @StreamListener(value = Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public String process(OrderMaster message){
        log.info("StreamReceiver:{}",message);
        return "received";
    }
    @StreamListener(value = Source.OUTPUT)
    public void process2(String message){
        log.info("StreamReceiver:{}",message);
    }
}



