package com.apigateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
  @LoadBalanced

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
