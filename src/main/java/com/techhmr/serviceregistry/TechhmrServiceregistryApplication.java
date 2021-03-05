package com.techhmr.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TechhmrServiceregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechhmrServiceregistryApplication.class, args);
	}

}
