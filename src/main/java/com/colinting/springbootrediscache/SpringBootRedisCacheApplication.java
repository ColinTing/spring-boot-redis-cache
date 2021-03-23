package com.colinting.springbootrediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@SpringBootApplication
@ConfigurationPropertiesScan("com.colinting.springbootrediscache.config")
public class SpringBootRedisCacheApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisCacheApplication.class, args);
    }




}
