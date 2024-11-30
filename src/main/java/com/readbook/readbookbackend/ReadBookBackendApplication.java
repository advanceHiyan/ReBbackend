package com.readbook.readbookbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 扫描拦截器
public class ReadBookBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReadBookBackendApplication.class, args);
    }
}
