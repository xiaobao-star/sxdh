package com.tydh.sxdh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.tydh.sxdh.mapper")
@SpringBootApplication
public class SxdhApplication {

	public static void main(String[] args) {
		SpringApplication.run(SxdhApplication.class, args);
	}

}
