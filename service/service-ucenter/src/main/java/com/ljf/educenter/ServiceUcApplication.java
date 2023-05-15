package com.ljf.educenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/16
 */
@ComponentScan({"com.ljf"})
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ljf.educenter.mapper")
public class ServiceUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUcApplication.class);
    }
}
