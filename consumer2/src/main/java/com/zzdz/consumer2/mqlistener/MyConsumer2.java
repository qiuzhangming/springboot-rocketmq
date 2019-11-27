package com.zzdz.consumer2.mqlistener;

import com.zzdz.consumer2.model.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Classname MyConsumer2
 * @Description TODO
 * @Date 2019/11/27 17:19
 * @Created by joe
 */
@Slf4j
//@Service
@RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-222", messageModel = MessageModel.BROADCASTING)
public class MyConsumer2 implements RocketMQListener<OrderPaidEvent> {

    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("received orderPaidEvent: {}", orderPaidEvent);
    }
}
