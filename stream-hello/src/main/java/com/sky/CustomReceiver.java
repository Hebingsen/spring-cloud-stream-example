package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 自定义消费者通道
 */
@Slf4j
@EnableBinding(CustomSink.class)
public class CustomReceiver {


    @StreamListener(CustomSink.INPUT)
    public void process(Object payload){
        log.info("receive data : " + payload);
    }

}
