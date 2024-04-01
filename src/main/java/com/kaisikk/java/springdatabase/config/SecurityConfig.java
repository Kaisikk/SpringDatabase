package com.kaisikk.java.springdatabase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("kaisik")
                .password("kaisik").authorities("ROLE_USER");
    }

}
