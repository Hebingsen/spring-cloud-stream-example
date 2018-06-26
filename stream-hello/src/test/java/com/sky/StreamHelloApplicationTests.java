package com.sky;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 总结:input相当于接收者(消费者)的队列,output相当于发送者(生产者)的队列
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {StreamHelloApplicationTests.SinkSender.class,
		StreamHelloApplicationTests.CustomSinkSender.class})
public class StreamHelloApplicationTests {

	@Autowired
	private SinkSender sinkSender;

	@Autowired
	private CustomSinkSender customSinkSender;

	@Test
	public void testSinkSender() {
		sinkSender.output().send(MessageBuilder.withPayload("send hello world from SinkSender").build());
		customSinkSender.output().send(MessageBuilder.withPayload("send hello world2 from CustomSinkSender").build());
	}


	/**
	 * 发送者接口
	 */
	public interface SinkSender{

		// channel name 指定通道名称
		String OUTPUT = "input";

		@Output(SinkSender.OUTPUT)
		MessageChannel output();
	}

	/**
	 * 发送者接口
	 */
	public interface CustomSinkSender{

		// channel name 指定通道名称
		String OUTPUT = "custom";

		@Output(CustomSinkSender.OUTPUT)
		MessageChannel output();
	}

}
