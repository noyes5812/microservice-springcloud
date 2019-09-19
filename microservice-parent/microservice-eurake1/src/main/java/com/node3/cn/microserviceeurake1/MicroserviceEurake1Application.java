package com.node3.cn.microserviceeurake1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurake1Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurake1Application.class, args);
    }

}
