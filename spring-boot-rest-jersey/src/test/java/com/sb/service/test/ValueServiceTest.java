package com.sb.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.sb.service.ValueService;

@RunWith(SpringRunner.class)
public class ValueServiceTest {

	@Autowired
	private ValueService valueService;
	
	@Configuration
    @ComponentScan ( basePackages = { "com.sb.service"} )
    static class ContextConfiguration {
      
	}
	
	@Before
	public void setup() {
	    ReflectionTestUtils.setField(valueService, "valueFromFile", "omeurl");
	} 
	
	@Test
	public void test() {
		System.out.println(valueService);
		System.out.println(valueService.getValueFromFile());
	}
}
