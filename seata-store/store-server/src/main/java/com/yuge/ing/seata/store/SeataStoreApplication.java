package com.yuge.ing.seata.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuge.ing.seata.store.mapper")
public class SeataStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStoreApplication.class, args);
    }

}