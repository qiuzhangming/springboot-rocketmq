package com.zzdz.consumer2.mqlistener;

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
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_2", consumeMode = ConsumeMode.CONCURRENTLY)
public class MyConsumer1 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
//        log.info("received message: {}...", message);
        throw new RuntimeException("模拟消费失败");
    }
}
