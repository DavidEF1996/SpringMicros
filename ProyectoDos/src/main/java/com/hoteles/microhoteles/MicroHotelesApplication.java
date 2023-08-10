package com.hoteles.microhoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroHotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroHotelesApplication.class, args);
	}

}
