package com.tecsolvent.wizspeak.notification.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

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
		
	}
	
	@Test
	public void testSave() throws NotificationLogicException {
		long assocId = 5001;		
		notificationService.save(userId, Notification.Category.AMBITION, assocId, Notification.Type.COMMENT, new HashMap<String, String>());		
	}
	
	@Test
	public void testGet() throws NotificationLogicException {
		long assocId = 5001;
		notificationService.save(userId, Notification.Category.AMBITION, assocId, Notification.Type.COMMENT, new HashMap<String, String>());
		List<Notification> notifications = notificationService.get(userId);
		assertTrue(notifications.size() == 1);
		assertTrue(notifications.get(0).getUserId() == userId);
	}
	
	@Test(expected=NotificationLogicException.class) 
	public void testInvalidOffset() throws NotificationLogicException {
		long assocId = 5001;
		notificationService.save(userId, Notification.Category.AMBITION, assocId, Notification.Type.COMMENT, new HashMap<String, String>());
		notificationService.get(assocId, 1, 1);
	}
	
	@Test(expected=NotificationLogicException.class) 
	public void testInvalidLimit() throws NotificationLogicException {
		long assocId = 5001;
		notificationService.save(userId, Notification.Category.AMBITION, assocId, Notification.Type.COMMENT, new HashMap<String, String>());
		notificationService.get(assocId, 0, 3);
	}
	
	@Test
	public void testGetLimitOffset() throws NotificationLogicException {
		long assocId = 5001;
		for (int i = 0; i < 1000; i++) {
			notificationService.save(userId, Notification.Category.AMBITION, assocId++, Notification.Type.COMMENT, new HashMap<String, String>());
		}
		List<Notification> randomNotifications = notificationService.get(userId, 0, 100);
		assertTrue(randomNotifications.size() == 100);
	}
	
	@Test
	public void testEmptyGetAll() throws NotificationLogicException {
		List<Notification> notifications = notificationService.get(userId);
		assertNotNull(notifications);
		assertEquals(0, notifications.size());
	}
	
	

}
