package com.example.mall.user.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户中心生产者启动类
 * @author liuyanzhao
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.mall.user.core.dao")
@EnableFeignClients(basePackages = "com.example.mall")
public class MallUserCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserCoreApplication.class, args);
    }

}
