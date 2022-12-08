package com.miracle.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
public class ConfigServerApplication {

// URL IS - http://localhost:8888/config-client-manish/default/master	
	public static void main(String[] args) {
		System.out.println("SPRING CLOUD CONFIG SERVER INITIATED");
		SpringApplication.run(ConfigServerApplication.class, args);
		System.out.println("SPRING CLOUD CONFIG SERVER STARTED ");
	}

}
