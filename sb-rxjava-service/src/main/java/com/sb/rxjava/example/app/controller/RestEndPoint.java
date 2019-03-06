package com.sb.rxjava.example.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.rxjava.example.app.service.AppProcessor;

import rx.Observable;

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
		Runnable runnable = () -> System.out.println("in startWork .... My thread is :" + Thread.currentThread().getName());
		System.out.println(sampleProperty.getTwo());
		
		
		System.out.println("started to test async rx");
		
		justExample();
		
	
		System.out.println("ended testing async rx");
        return "hello";
    }

	private void justExample() {
		System.out.println("in justExample .... My thread is :" + Thread.currentThread().getName());
		Observable<Integer> observable = appProcessor.getNumbers1to10();
		observable.subscribe(n -> System.out.print(n));
	}

	
	
}
