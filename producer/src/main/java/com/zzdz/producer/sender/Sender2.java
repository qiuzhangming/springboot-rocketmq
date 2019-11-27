package com.zzdz.producer.sender;

import com.zzdz.producer.model.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Classname Sender2
 * @Description TODO
 * @Date 2019/11/27 17:40
 * @Created by joe
 */
@Slf4j
@Service
public class Sender2 {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    private static AtomicInteger count = new AtomicInteger(1);

    private static AtomicLong price = new AtomicLong(1);

    @Async
    //@Scheduled(cron = "0/1 * * * * ?")
    public void send1() {
        SendResult sendResult = rocketMQTemplate.syncSend("test-topic-1", "Hello, World!" + count.getAndIncrement());
        log.info("syncSend：{}",sendResult.toString());
    }

    @Async
//    @Scheduled(cron = "0/1 * * * * ?")
    public void send2() {
        rocketMQTemplate.convertAndSend("test-topic-2", new OrderPaidEvent("T_001", new BigDecimal(price.getAndIncrement())));
        log.info("test-topic-2");
    }

    @Async
    @Scheduled(cron = "0/1 * * * * ?")
    public void send3() {
        SendResult sendResult = rocketMQTemplate.syncSendOrderly("test-topic-3", "Hello, World!" + count.getAndIncrement(), "1234");
        log.info("syncSendOrderly：{}",sendResult.toString());
    }
}
