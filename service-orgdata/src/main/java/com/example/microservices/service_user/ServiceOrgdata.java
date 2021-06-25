package com.example.microservices.service_user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication @EnableEurekaClient
public class ServiceOrgdata {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrgdata.class, args);
    }
}