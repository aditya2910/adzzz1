package com.sb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringValueClass {

	@Value("${value.from.file}")
	private String valueFromFile;
	
	
	public  String getValueFromFile() {
		return valueFromFile;
	}
}
