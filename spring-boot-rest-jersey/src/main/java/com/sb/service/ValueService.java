package com.sb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueService {

	@Value("${a.b}")
	private String valueFromFile;
	
	
	public  String getValueFromFile() {
		return valueFromFile;
	}
}
