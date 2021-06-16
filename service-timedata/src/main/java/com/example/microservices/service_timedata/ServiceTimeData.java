package com.example.microservices.service_timedata;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication @EnableEurekaClient
public class ServiceTimeData {
    public static void main(String[] args) {
        SpringApplication.run(ServiceTimeData.class, args);
    }
}