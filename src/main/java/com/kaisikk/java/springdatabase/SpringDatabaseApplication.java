package com.kaisikk.java.springdatabase;

import com.kaisikk.java.springdatabase.model.LanguageMongo;
import com.kaisikk.java.springdatabase.model.LanguageMySQL;
import com.kaisikk.java.springdatabase.repo.LanguageMongoRepo;
import com.kaisikk.java.springdatabase.repo.LanguageMySQLRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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

