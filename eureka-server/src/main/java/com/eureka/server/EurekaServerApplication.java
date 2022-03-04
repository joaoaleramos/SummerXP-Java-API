package com.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication

public class EurekaServerApplication {
@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
