package com.zzdz.consumer2.mqlistener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
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
@RocketMQMessageListener(topic = "test-topic-4", consumerGroup = "my-consumer_2_2", selectorExpression = "hehe")
public class MyConsumer4 implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        log.info("tags:{}", message.getTags());
        log.info("received test-topic-4 message: {}", message.toString());
    }
}
