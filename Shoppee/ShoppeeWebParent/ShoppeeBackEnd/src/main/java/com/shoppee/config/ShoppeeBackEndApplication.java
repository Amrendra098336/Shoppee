package com.shoppee.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.shoppee.common.entity", "com.shoppee"})
public class ShoppeeBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppeeBackEndApplication.class, args);
	}

}
