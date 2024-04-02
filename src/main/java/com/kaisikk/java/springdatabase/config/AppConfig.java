package com.kaisikk.java.springdatabase.config;

import com.kaisikk.java.springdatabase.filter.LogginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.yandex.ru");
        mailSender.setPort(1337);

        mailSender.setUsername("123");
        mailSender.setPassword("123");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.enable", "true");


        return mailSender;
    }

    @Bean
    public FilterRegistrationBean<LogginFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<LogginFilter> filterFilterRegistrationBean = new FilterRegistrationBean();
        filterFilterRegistrationBean.setFilter(new LogginFilter());
        filterFilterRegistrationBean.addUrlPatterns("");
        return filterFilterRegistrationBean;
    }


}
