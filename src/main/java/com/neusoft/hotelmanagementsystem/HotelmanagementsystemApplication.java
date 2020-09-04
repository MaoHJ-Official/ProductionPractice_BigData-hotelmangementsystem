package com.neusoft.hotelmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.neusoft.hotelmanagementsystem.mapper"})
public class HotelmanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelmanagementsystemApplication.class, args);
    }

}
