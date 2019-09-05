package com.dylan.userprovidersss.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dylan.userprovidersss")
@MapperScan(basePackages = "com.dylan.userprovidersss.dal.dao")
public class UserProvidersssApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProvidersssApplication.class, args);
    }

}
