package com.example.sensorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan(basePackages = "com.example.sensorapi.entity")
@EnableJpaRepositories(basePackages = "com.example.sensorapi.repository")
public class SensorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorApiApplication.class, args);
    }
}
