package com.mml.mvctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.mml.mvctest.model")
@SpringBootApplication
public class MvcTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcTestApplication.class, args);
	}

}
