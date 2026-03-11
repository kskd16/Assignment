package com.lpu.deposit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class DepositApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepositApplication.class, args);
	}

}
