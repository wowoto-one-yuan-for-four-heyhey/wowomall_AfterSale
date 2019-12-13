package com.xmu.wowoto.aftersale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.xmu.wowoto.aftersale.mapper")
public class AftersaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AftersaleApplication.class, args);
    }

}
