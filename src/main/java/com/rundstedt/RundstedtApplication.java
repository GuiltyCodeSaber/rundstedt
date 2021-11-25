package com.rundstedt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class RundstedtApplication {
    public static void main(String[] args) {
        SpringApplication.run(RundstedtApplication.class, args);
    }

}
