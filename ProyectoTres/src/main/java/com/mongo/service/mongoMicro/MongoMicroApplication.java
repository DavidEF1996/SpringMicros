package com.mongo.service.mongoMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MongoMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoMicroApplication.class, args);
	}

}
