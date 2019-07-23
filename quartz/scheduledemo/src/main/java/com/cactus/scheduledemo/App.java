package com.cactus.scheduledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.cactus.scheduledemo.dao"})
@EntityScan("com.cactus.scheduledemo.domain")
@EnableAsync
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
