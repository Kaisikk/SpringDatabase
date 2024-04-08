package com.kaisikk.java.springdatabase.events;

import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
public class BNControllerRest {

    /**
     * Список подписчиков на событие
     */
    private final Set<SseEmitter> subscribers = new CopyOnWriteArraySet<>();

    /**
     * Сюда заходит js и попадает в подписчики на событие
     *
     * @return SseEmitter
     */
    @GetMapping("/news-stream")
    public SseEmitter events(){
        SseEmitter emitter = new SseEmitter();
        subscribers.add(emitter);

        emitter.onTimeout(() -> subscribers.remove(emitter));
        emitter.onCompletion(() -> subscribers.remove(emitter));
        return emitter;
    }

    @Async
    @EventListener
    public void handleNews(BreakingNews breakingNews){
        List<SseEmitter> deadEmmiters = new ArrayList<>();

        subscribers.forEach(emitter -> {
            try {
                emitter.send(breakingNews, MediaType.APPLICATION_JSON);
            } catch (Exception ex) {
            deadEmmiters.add(emitter);
            }
        });
        subscribers.removeAll(deadEmmiters);
    }

}
