package com.yuge.ing.seata.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuge.ing.seata.demo.mapper")
public class SeataDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataDemoApplication.class, args);
    }

}
