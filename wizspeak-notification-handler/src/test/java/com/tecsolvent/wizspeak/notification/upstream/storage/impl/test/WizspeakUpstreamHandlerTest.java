package com.tecsolvent.wizspeak.notification.upstream.storage.impl.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;
import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;
import com.tecsolvent.wizspeak.notification.upstream.handler.impl.WizspeakUpstreamHandler;
import com.tecsolvent.wizspeak.notification.upstream.storage.impl.KeyValueCache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class WizspeakUpstreamHandlerTest {
	
	@Autowired
	private KeyValueCache keyValueCache;
	
	@Autowired
	private WizspeakUpstreamHandler wizspeakUpstreamHandler;
	
	@Test
	public void beanAutowireTest() throws InterestedPartiesHandlerException {
		System.out.println("Hi.... " + keyValueCache);
		//keyValueCache.addElements(null, null);
	}
	
	@Test
	public void sendNotificationTest() {
		System.out.println("wizspeakUpstreamHandler: " + wizspeakUpstreamHandler);
		Map<String, String> msgContainer = new HashMap<>();
		wizspeakUpstreamHandler.sendNotification("actorId", Long.MAX_VALUE, Type.COMMENT, msgContainer);
	}

}
