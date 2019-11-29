package com.zzdz.consumer1.mqlistener;

import com.zzdz.consumer1.model.OrderPaidEvent;
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
@Service
@RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_1", messageModel = MessageModel.BROADCASTING)
public class MyConsumer2 implements RocketMQListener<OrderPaidEvent> {

    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.warn("received orderPaidEvent: {}", orderPaidEvent);
    }
}
