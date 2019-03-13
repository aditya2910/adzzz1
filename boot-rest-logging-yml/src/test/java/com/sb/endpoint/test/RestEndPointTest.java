package com.sb.endpoint.test;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sb.endpoint.SampleControllerLoggingYml;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SampleControllerLoggingYml.class, secure = false)
public class RestEndPointTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private SampleControllerLoggingYml restEndPoint;
	
	@Configuration
    @ComponentScan ( basePackages = {"com.sb.worker", "com.sb.endpoint"} )
    static class ContextConfiguration {
        
    }
	
	@Before
	public void init(){
		Assert.assertNotNull(mockMvc);
		Assert.assertNotNull(restEndPoint);
	}
	
	@Test
	public void defaultEndPointTest() throws UnsupportedEncodingException{
		System.out.println("Start of test.");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Actual Response: " + result.getResponse().getContentAsString());
		Assert.assertEquals("Default Handler response Success", result.getResponse().getContentAsString());
	}
	
	@Test
	public void startWorkTest() throws UnsupportedEncodingException{
		System.out.println("Start of test.");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Actual Response: " + result.getResponse().getContentAsString());
		Assert.assertEquals("Work Done !", result.getResponse().getContentAsString());
	}

}
