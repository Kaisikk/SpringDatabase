package com.kaisikk.java.springdatabase.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(String msg) throws InterruptedException {
        Thread.sleep(5000);
    log.info("Consume: " + msg);
    }
}
