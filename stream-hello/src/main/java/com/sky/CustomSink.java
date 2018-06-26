package com.sky;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomSink {

    String INPUT = "custom";

    @Input("custom")
    SubscribableChannel input();
}
