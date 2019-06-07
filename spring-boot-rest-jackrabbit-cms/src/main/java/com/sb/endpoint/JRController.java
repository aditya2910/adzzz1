package com.sb.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.config.Traceable;
import com.sb.service.JackRabbitServiceImpl;
import com.sb.service.SpringValueClass;
import com.sb.util.AppUtil;

@RestController
@RequestMapping("/jr")
public class JRController {
	
	Logger LOGGER = LoggerFactory.getLogger(JRController.class);
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private JackRabbitServiceImpl jackRabbitService;
	
	@Autowired
	private SampleProperty sampleProperty;
	
	@Autowired
	private SpringValueClass springValueClass;
	
	@Traceable
	@RequestMapping(value = "/save" , method= RequestMethod.GET)
    public String startWork() {
		System.out.println("..........................................get context: " + context);
		System.out.println(sampleProperty.getTwo());
		//jackRabbitService.saveContent(AppUtil.getContentToSaveInJR());
		System.out.println(springValueClass.getValueFromFile());
        return "hello";
    }
	
	
	
}
