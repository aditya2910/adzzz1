package com.sb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.service.JackRabbitServiceImpl;
import com.sb.util.AppUtil;

@RestController
@RequestMapping("/jr")
public class RestEndPoint {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private JackRabbitServiceImpl jackRabbitService;
	
	@Autowired
	private SampleProperty sampleProperty;
	
	@RequestMapping(value = "/save" , method= RequestMethod.GET)
    public String startWork() {
		System.out.println("..........................................get context: " + context);
		System.out.println(sampleProperty.getTwo());
		jackRabbitService.saveContent(AppUtil.getContentToSaveInJR());
		
        return "hello";
    }
	
	
	
}
