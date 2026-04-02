package com.example.companiescrudms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompaniesCrudMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompaniesCrudMsApplication.class, args);
    }

}
