package com.kaisikk.java.springdatabase.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WorkSchedule {

    static int i = 1;

//    @Scheduled(initialDelay = 1000, fixedDelayString = "${schedule.work}")
    @Scheduled(cron = "*/5 * * * * ?")
    public void runFirst() throws InterruptedException {
        System.out.println("Start! i = " + i);
        i++;
        Thread.sleep(5000);
        System.out.println("Finish! i = " + i);
    }

//    @Scheduled(fixedRate = 5000)
//    public void runSecond() throws InterruptedException {
//        System.out.println("Run Second!");
//
//        i++;
//
//        Thread.sleep(5000);
//        System.out.println("Second Finish! i = " + i);
//    }

}
