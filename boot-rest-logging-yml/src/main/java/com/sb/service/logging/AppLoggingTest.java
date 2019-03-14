package com.sb.service.logging;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppLoggingTest {
	
	Logger LOGGER = LoggerFactory.getLogger(AppLoggingTest.class);

	public void doSomeLogging() {
		LOGGER.info("Hi. I am getting logged from AppLoggingTest -> doSomeLogging()");
	}
	
	public void doSomeLogging(String id) {
		LOGGER.info("Before - Hi. I am getting logged from AppLoggingTest -> doSomeLogging() :: is: {}", id);
		MDC.put("mdc_Key_1", id);
		LOGGER.info("After - Hi. I am getting logged from AppLoggingTest -> doSomeLogging() :: is: {}", id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.info("Post sleep");
	}

}
