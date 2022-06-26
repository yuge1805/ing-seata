package com.yuge.ing.seata.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.yuge.ing.seata.order.api")
public class SeataPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataPortalApplication.class, args);
    }

}
