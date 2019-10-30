package com.zzw.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zhangzhiwen
 */
public interface StreamClient {
    /**
     * @return
     */
    @Input(Sink.INPUT)
    SubscribableChannel input();

    /**
     *
     * @return
     */
    @Output(Source.OUTPUT)
    MessageChannel output();


}
