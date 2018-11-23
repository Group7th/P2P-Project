package com.group7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableTransactionManagement//spring boot 开启注解式事务
@SpringBootApplication
@MapperScan("com.group7.dao")
public class SpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootApplication.class);
    }
}
