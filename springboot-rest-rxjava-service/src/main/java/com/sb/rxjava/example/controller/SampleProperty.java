package com.sb.rxjava.example.controller;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "one")
@Component
public class SampleProperty {
    private Map<String, Object> two;

	public Map<String, Object> getTwo() {
		return two;
	}

	public void setTwo(Map<String, Object> two) {
		this.two = two;
	}


	
}
