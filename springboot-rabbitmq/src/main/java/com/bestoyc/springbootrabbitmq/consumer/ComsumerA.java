package com.bestoyc.springbootrabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "smsdirectqueue")
public class ComsumerA {

    @RabbitHandler
    public void process(Object testMessage) {
        if (testMessage instanceof Message) {
            Message testMessage1 = (Message) testMessage;
            System.out.println("ComsumerA 消费者 从 smsdirectqueue 队列中 收到消息  : " + testMessage1);
        }
        System.out.println("ComsumerA 消费者 从 smsdirectqueue 队列中 收到消息  : " + testMessage);
    }
}

