package com.example.zipkinservice3;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootElkZipkinApp3 {

	public static void main(String[] args) {
		SpringApplication.run(BootElkZipkinApp3.class, args);
	}
}
@RestController
class BootElkZipkinAppController{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}
	
	private static final Logger LOG = Logger.getLogger(BootElkZipkinAppController.class.getName());
	
	@GetMapping(value="/bootelkzipkin3")
	public String bootElkZipkinService3() {
		LOG.info("Inside BootElkZipkinApp3 bootElkZipkinService3..");
		String response = (String) restTemplate.exchange("http://localhost:6084/bootelkzipkin4", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();
		return "Final Response service 3: " + response;
	}
}