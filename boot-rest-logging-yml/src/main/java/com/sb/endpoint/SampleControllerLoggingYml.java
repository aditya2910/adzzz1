package com.sb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.service.logging.AppLoggingTest;

@RestController
@RequestMapping("/v1")
public class SampleControllerLoggingYml {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SampleProperty sampleProperty;
	
	@Autowired
	private AppLoggingTest appLoggingTest;
	
	
	@RequestMapping(value = "/hello" , method= RequestMethod.GET)
    public String startWork() {
		System.out.println(".......... Inside /v1/hello startWork() : " + context);
		
		System.out.println(sampleProperty.getTwo());
		
		
		appLoggingTest.doSomeLogging();
		
        return "hello";
    }
	
}
