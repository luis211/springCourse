package com.artur.example.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerBeanConfig {
    @Bean
    public Faker getFakerr(){
        return new Faker();
    }
}
