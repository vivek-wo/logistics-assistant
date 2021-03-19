package com.lanfang.logistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lanfang.logistics.mapper")
public class LogisticsAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsAssistantApplication.class, args);
    }

}
