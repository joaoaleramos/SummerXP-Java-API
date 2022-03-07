package com.orders.api.ordersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrdersApiApplication {
	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(OrdersApiApplication.class, args);
	}

}
