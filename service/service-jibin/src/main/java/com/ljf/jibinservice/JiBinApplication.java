package com.ljf.jibinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/11
 */

@SpringBootApplication
@EnableDiscoveryClient //nacos注册
@EnableFeignClients
@ComponentScan(basePackages = {"com.ljf"})
public class JiBinApplication {
    public static void main(String[] args) {
        SpringApplication.run(JiBinApplication.class, args);
    }
}
