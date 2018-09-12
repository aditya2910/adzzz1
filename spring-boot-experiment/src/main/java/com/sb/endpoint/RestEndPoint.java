package com.sb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.service.test.primary.Car;

@RestController
@RequestMapping("/main")
public class RestEndPoint {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SampleProperty sampleProperty;
	
	@Autowired
	private Car car;
	
	@Autowired
	@Qualifier("bmw")
	private Car car2;
	
	@RequestMapping(value = "/hello" , method= RequestMethod.GET)
    public String startWork() {
		System.out.println("..........................................get context: " + context);
		System.out.println(sampleProperty.getTwo());
		car.wheels();
		car2.wheels();
        return "hello";
    }
	
	
	@RequestMapping(value = "/abc" , method= RequestMethod.POST)
    public String defaultEndpoint() {
		System.out.println(".......................................post...Default ");
        return "Default Handler response Success";
    }
	
	
}
