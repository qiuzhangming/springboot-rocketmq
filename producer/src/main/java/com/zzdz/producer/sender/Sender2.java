package com.zzdz.producer.sender;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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

    @Async
    @Scheduled(cron = "0/1 * * * * ?")
    public void send1() {
        SendResult sendResult = rocketMQTemplate.syncSend("test-topic-1", "Hello, World!");
        log.info(sendResult.toString());
    }
}
