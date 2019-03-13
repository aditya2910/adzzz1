package com.sb.service.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppLoggingTest {
	
	Logger LOGGER = LoggerFactory.getLogger(AppLoggingTest.class);

	public void doSomeLogging() {
		LOGGER.info("Hi. I am getting logged from AppLoggingTest -> doSomeLogging()");
	}

}
