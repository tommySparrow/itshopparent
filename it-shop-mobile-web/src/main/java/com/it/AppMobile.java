package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AppMobile {
    public static void main(String[] args) {
        SpringApplication.run(AppMobile.class,args);
    }
}
