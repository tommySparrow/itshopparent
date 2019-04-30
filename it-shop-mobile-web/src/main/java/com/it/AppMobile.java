package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class AppMobile {
    public static void main(String[] args) {
        SpringApplication.run(AppMobile.class,args);
    }
}
