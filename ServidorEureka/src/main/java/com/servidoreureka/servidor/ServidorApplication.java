package com.servidoreureka.servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorApplication.class, args);
	}

}
