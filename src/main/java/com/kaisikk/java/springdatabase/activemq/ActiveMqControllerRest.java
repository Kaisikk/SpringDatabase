package com.kaisikk.java.springdatabase.activemq;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/active")
public class ActiveMqControllerRest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping(value = "/send/{message}", produces = "text/html")
    public String sendMessage(@PathVariable("message") String message){
        val click = new Click();
        click.setName(message);
        click.setCount(ThreadLocalRandom.current().nextInt(20));
        jmsTemplate.convertAndSend("superqueue", click);
        return "done. sent: " + message;
    }

}
