package com.kaisikk.java.springdatabase.events;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Класс Publisher который нужен для публикации событий
 */
@Component
public class BreakingNewsPoster {

    private ApplicationEventPublisher publisher;

    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    public void start(){
        this.executorService.schedule(this::action, 5, TimeUnit.SECONDS);
    }

    /**
     * Публикация ивента
     */
    private void action(){

        BreakingNews news = new BreakingNews();
        news.setData("news: " + ThreadLocalRandom.current().nextInt(20));
        publisher.publishEvent(news);
        executorService.schedule(this::action, ThreadLocalRandom.current().nextInt(20), TimeUnit.SECONDS);

    }

}
