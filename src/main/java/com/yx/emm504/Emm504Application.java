package com.yx.emm504;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Emm504Application {

	public static void main(String[] args) {
		SpringApplication.run(Emm504Application.class, args);
	}
}
