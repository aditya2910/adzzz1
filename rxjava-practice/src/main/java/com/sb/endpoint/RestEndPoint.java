package com.sb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class RestEndPoint {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SampleProperty sampleProperty;
	
	@RequestMapping(value = "/hello" , method= RequestMethod.GET)
    public String startWork() {
		System.out.println("..........................................get context: " + context);
		System.out.println(sampleProperty.getTwo());
        return "hello";
    }
	
	
	@RequestMapping(value = "/abc" , method= RequestMethod.POST)
    public String defaultEndpoint() {
		System.out.println(".......................................post...Default ");
        return "Default Handler response Success";
    }
	
	
}
