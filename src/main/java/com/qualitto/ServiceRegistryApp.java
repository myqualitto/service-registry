package com.qualitto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
public class ServiceRegistryApp {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApp.class, args);
	}

	@Value("${spring.application.name}")
	private String name;

	@RequestMapping(value = "/")
	public String name() {
		return name;
	}
}