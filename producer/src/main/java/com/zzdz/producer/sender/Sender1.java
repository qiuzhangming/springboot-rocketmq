package com.zzdz.producer.sender;

import com.zzdz.producer.model.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Classname Sender1
 * @Description TODO
 * @Date 2019/11/27 17:05
 * @Created by joe
 */
@Slf4j
//@Component
public class Sender1 implements CommandLineRunner {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) throws Exception {

        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
        rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        rocketMQTemplate.convertAndSend("test-topic-2", new OrderPaidEvent("T_001", new BigDecimal("88.00")));

        log.info("消息发送完成。");
//        rocketMQTemplate.destroy(); // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate

        while (true) {

//            SendResult sendResult = rocketMQTemplate.syncSend("TestMessage", "hello");
//            log.info(sendResult.toString());


//            rocketMQTemplate.asyncSend("TestMessage", "hello,async", new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
//                    log.info(sendResult.toString());
//                }
//
//                @Override
//                public void onException(Throwable throwable) {
//                    log.error(throwable.toString());
//                }
//            });

//            rocketMQTemplate.sendOneWay("TestMessage", "hello,one way");


            rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");

        }
    }
}

