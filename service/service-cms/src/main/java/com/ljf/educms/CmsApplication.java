package com.ljf.educms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/15
 */

@SpringBootApplication
@ComponentScan("com.ljf")
@MapperScan("com.ljf.educms.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
