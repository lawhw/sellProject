package com.zzw.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zhangzhiwen
 */
public interface StreamClient {
    /**
     * @return
     */
    @Input("myMessageIn")
    SubscribableChannel input();

    /**
     *
     * @return
     */
    @Output("myMessageOut")
    MessageChannel output();


}
