package com.codecool.shoppingcartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingcartserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartserviceApplication.class, args);
	}

}
