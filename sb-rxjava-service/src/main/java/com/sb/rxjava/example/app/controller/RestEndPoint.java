package com.sb.rxjava.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.rxjava.example.app.service.AppProcessor;

@RestController
@RequestMapping("/main")
public class RestEndPoint {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SampleProperty sampleProperty;
	
	@Autowired
	private AppProcessor appProcessor;
	
	@RequestMapping(value = "/hello" , method= RequestMethod.GET)
    public String startWork() {
		System.out.println("..........................................get context: " + context);
		System.out.println(sampleProperty.getTwo());
		System.out.println("appProcessor: " + appProcessor);
        return "hello";
    }

	
	
}
