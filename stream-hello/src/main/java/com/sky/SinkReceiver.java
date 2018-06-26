package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 创建用于接收来自RabbitMQ消息的消费者SinkReceiver
 * "@EnableBinding"，该注解用来指定一个或多个定义了@Input或@Output注解的接口，
 * 以此实现对消息通道（Channel）的绑定。在上面的例子中，我们通过@EnableBinding(Sink.class)绑定了Sink接口，
 * 该接口是Spring Cloud Stream中默认实现的对输入消息通道绑定的定义
 */
@EnableBinding(Sink.class)
@Slf4j
public class SinkReceiver {

    /**
     * "@StreamListener"：该注解主要定义在方法上，作用是将被修饰的方法注册为消息中间
     * 件上数据流的事件监听器，注解中的属性值对应了监听的消息通道名。
     * @param data
     */
    @StreamListener(Sink.INPUT)
    public void receive(Object data){
        log.info("receive data from queue = " + data);
    }





}
