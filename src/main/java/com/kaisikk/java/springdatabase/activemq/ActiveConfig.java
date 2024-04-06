package com.kaisikk.java.springdatabase.activemq;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.Collections;

/**
 * Конфигурация для маппинга объектов в json
 */
@Configuration
public class ActiveConfig {

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        val messageConverter = new org.springframework.jms.support.converter.MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("content-type");
        messageConverter.setTypeIdMappings(Collections.singletonMap("click", Click.class));
        return messageConverter;
    }

}
