package com.zzdz.consumer1.mqlistener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Classname MyConsumer1
 * @Description TODO
 * @Date 2019/11/27 17:19
 * @Created by joe
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "test-topic-3", consumerGroup = "my-consumer_11", consumeMode = ConsumeMode.ORDERLY)
public class MyConsumer3 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.error("received message: {}", message);
    }
}
