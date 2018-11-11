package com.chenshinan.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.chenshinan.transaction.infra.mapper")
public class CsnSpringTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsnSpringTransactionApplication.class, args);
    }
}
