package com.node3.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashbordConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashbordConsumerApplication.class,args);
    }
}
