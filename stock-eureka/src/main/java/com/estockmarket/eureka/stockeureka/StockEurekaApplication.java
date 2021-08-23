package com.estockmarket.eureka.stockeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class StockEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockEurekaApplication.class, args);
	}

}
