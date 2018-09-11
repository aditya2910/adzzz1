package com.sb.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class RestServiceHome {
	
	public static void main(String[] args) {
		SpringApplication.run(RestServiceHome.class, args);
	}
}
