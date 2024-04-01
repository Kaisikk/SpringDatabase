package com.kaisikk.java.springdatabase.controller;

import com.kaisikk.java.springdatabase.model.LanguageMongo;
import com.kaisikk.java.springdatabase.model.LanguageMySQL;
import com.kaisikk.java.springdatabase.repo.LanguageMongoRepo;
import com.kaisikk.java.springdatabase.repo.LanguageMySQLRepo;
import com.kaisikk.java.springdatabase.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
public class HomeController {

    @Autowired
    private LanguageMongoRepo languageMongoRepo;

    @Autowired
    private LanguageMySQLRepo languageMySQLRepo;

    @Autowired
    private MailService mailService;

    @GetMapping("/nosql")
    public Iterable<LanguageMongo> getAllLanguagesMongo() {
        return languageMongoRepo.findAll();
    }


    @GetMapping({"/", "/sql"})
    public Iterable<LanguageMySQL> getAllLanguagesMySQL() {
        return languageMySQLRepo.findAll();
    }

    @GetMapping("/email/{subject}")
    public String sendEmail(@PathVariable("subject") String subject){
    mailService.sendSimpleMessage(subject, "Test from boot");
    return "send";
    }

}
