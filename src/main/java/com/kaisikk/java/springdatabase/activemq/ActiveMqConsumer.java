package com.kaisikk.java.springdatabase.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActiveMqConsumer {

    @JmsListener(destination = "superqueue")
    public void processMessages(String message){
        log.info("Received: " + message);
    }

}
