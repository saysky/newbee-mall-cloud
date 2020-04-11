package com.example.mall.goods.core;

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
@EnableFeignClients(basePackages = "com.example.mall")
@MapperScan("com.example.mall.goods.core.dao")
public class MallGoodsCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGoodsCoreApplication.class, args);
    }

}
