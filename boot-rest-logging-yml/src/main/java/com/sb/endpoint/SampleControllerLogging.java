package com.sb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.service.logging.AppLoggingTest;

@RestController
@RequestMapping("/v1")
public class SampleControllerLogging {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SampleProperty sampleProperty;
	
	@Autowired
	private AppLoggingTest appLoggingTest;
	
	
	@RequestMapping(value = "/log" , method= RequestMethod.GET)
    public String log() {
		System.out.println(".......... Inside /v1/log log() : " + context);
		
		System.out.println(sampleProperty.getTwo());
		
		
		appLoggingTest.doSomeLogging();
		
        return "hello";
    }
	
	@RequestMapping(value = "/log/{id}" , method= RequestMethod.GET)
    public String log2(@PathVariable String id) {
		System.out.println(".......... Inside /v1/log log() : " + context);
		
		System.out.println(sampleProperty.getTwo());
		
		
		appLoggingTest.doSomeLogging(id);
		
        return "hello";
    }
	
}
