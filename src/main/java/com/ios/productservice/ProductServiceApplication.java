package com.ios.productservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ProductServiceApplication {

	public static void main(String[] args) {
		log.info("Welcome To The PRODUCT SERVCIE APP...!");
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
