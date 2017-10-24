package com.tecsolvent.wizspeak.notification.upstream.storage.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;
import com.tecsolvent.wizspeak.notification.upstream.storage.impl.KeyValueCache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class KeyValueCacheTest {
	
	@Autowired
	KeyValueCache keyValueCache;
	
	@Test
	public void beanAutowireTest() throws InterestedPartiesHandlerException {
		System.out.println("Hi.... " + keyValueCache);
		keyValueCache.addElements(null, null);
	}

}
