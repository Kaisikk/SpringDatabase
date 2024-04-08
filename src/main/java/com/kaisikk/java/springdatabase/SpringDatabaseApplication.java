package com.kaisikk.java.springdatabase;

import com.kaisikk.java.springdatabase.repo.LanguageMongoRepo;
import com.kaisikk.java.springdatabase.repo.LanguageMySQLRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableJms
@EnableAsync
//@EnableScheduling
public class SpringDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDatabaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner preload(LanguageMySQLRepo mySQLRepo, LanguageMongoRepo mongoRepo) {
        return args -> {
        };
    }
}

