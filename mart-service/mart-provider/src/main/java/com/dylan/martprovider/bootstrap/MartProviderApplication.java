package com.dylan.martprovider.bootstrap;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dylan.martprovider")
@MapperScan(basePackages = "com.dylan.martprovider.dal.dao")
public class MartProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MartProviderApplication.class, args);
    }

}
