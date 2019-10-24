package com.zzw.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
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

    @StreamListener(value = "myMessageOut")
    public void process(String message){
        log.info("StreamReceiver:{}",message);
    }
}
