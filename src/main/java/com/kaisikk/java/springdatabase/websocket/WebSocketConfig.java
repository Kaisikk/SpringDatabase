package com.kaisikk.java.springdatabase.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * Регистрация класса вебсокета
     *
     * @return PongWebSocket
     */
    @Bean
    public PongWebSocket pongWebSocket(){
        return new PongWebSocket();
    }

    /**
     * Подвязываем класс вебсокета к определенному url
     *
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(pongWebSocket(), "/pong");
    }

}
