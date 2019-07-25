package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class ClientWebApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientWebApplication1Application.class, args);
	}

}
