package com.example.metricworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MetricWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetricWorkshopApplication.class, args);
    }

}
