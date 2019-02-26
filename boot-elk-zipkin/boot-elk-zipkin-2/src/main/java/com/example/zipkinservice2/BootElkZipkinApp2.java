package com.example.zipkinservice2;

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
public class BootElkZipkinApp2 {

	public static void main(String[] args) {
		SpringApplication.run(BootElkZipkinApp2.class, args);
	}
}

@RestController
class BootElkZipkinAppController {
	
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
	
	@GetMapping(value="/bootelkzipkin2")
	public String bootElkZipkinService2() {
		LOG.info("Inside BootElkZipkinApp2 BootElkZipkinAppController bootElkZipkinService2..");
		LOG.info("Some processing happening in service 2......");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String response = (String) restTemplate.exchange("http://localhost:6083/bootelkzipkin3", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();
		return "Final Response service 2: " + response;
	}
}