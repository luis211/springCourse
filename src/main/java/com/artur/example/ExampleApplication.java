package com.artur.example;

import com.artur.example.entities.User;
import com.artur.example.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication implements ApplicationRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setPassword(faker.dragonBall().character());
            user.setProfile(null);
            repository.save(user);
        }
    }
}
