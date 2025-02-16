package com.example.self;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.self.**.mapper")
public class SelfApplication {

    public static void main(String[] args) {


        SpringApplication.run(SelfApplication.class, args);
    }

}
