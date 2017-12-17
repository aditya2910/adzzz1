package com.tecsolvent.wizspeak.notification.services;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAOImpl;

public class NotificationServiceImplTest {
	
	private NotificationServiceImpl notificationService;
	private NotificationDAOImpl notificationDAO;
	
	private static final long userId = 100000;

	@Before
	public void setUp() {
		notificationService = new NotificationServiceImpl();
		notificationDAO = new NotificationDAOImpl();
		notificationService.setNotificationDAO(notificationDAO);
	}
	
	@After
	public void tearDown() {
		notificationService = null;
		notificationDAO = null;
	}
	
	@Test
	public void testSave() throws NotificationLogicException {
		long assocId = 5001;		
		notificationService.save(userId, Notification.Category.AMBITION, assocId, Notification.Type.COMMENT, new HashMap<String, String>());		
	}
	
}
