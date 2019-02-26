package com.example.zipkinservice4;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootElkZipkinApp4 {

	public static void main(String[] args) {
		SpringApplication.run(BootElkZipkinApp4.class, args);
	}
}

@RestController
class BootElkZipkinAppController {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}

	private static final Logger LOG = Logger.getLogger(BootElkZipkinAppController.class.getName());

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@GetMapping(value = "/bootelkzipkin4")
	public String bootElkZipkinService4() {
		LOG.info("Inside BootElkZipkinAppController bootElkZipkinService4..");
		return "Final Response service 4: " + "Hello World !";
	}
}