package com.tecsolvent.wizspeak.notification.services;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAOImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class NotificationServiceImplTest {
	
	@Autowired
	private NotificationServiceImpl notificationService;
	
	private static final long userId = 100000;
	
	@Test
	public void testSave() throws NotificationLogicException {
		long assocId = 5001;		
		notificationService.save(userId, Notification.Category.AMBITION, assocId, Notification.Type.COMMENT, new HashMap<String, String>());		
	}
	
}
