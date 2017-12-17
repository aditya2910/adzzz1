package com.tecsolvent.wizspeak.notification.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.NotificationCRUDException;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAO;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAOImpl;

public class ViewNotificationServiceImplTest {
	
	private ViewNotificationServiceImpl viewService;
	
	private NotificationDAO notificationDAO;
	
	private static final long userId = 100000;
	
	@Before
	public void setUp() {
		viewService = new ViewNotificationServiceImpl();
		notificationDAO = new NotificationDAOImpl();
		viewService.setNotificationDAO(notificationDAO);
	}
	
	@After
	public void tearDown() {
		viewService = null;
		notificationDAO = null;
	}

	@Test
	public void updateStatus() throws NotificationCRUDException, NotificationLogicException {
		Notification notification = new Notification("100", "", 12, "", 23, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
		notificationDAO.save(notification);
		viewService.updateStatus(notification.getId(), Notification.Status.UNREAD);
		assertEquals(Notification.Status.UNREAD, notification.getStatus());
	}
	
	@Test(expected=NotificationLogicException.class)
	public void updateNonExistentNotificationStatus() throws NotificationLogicException {
		viewService.updateStatus("eewqe", Notification.Status.READ);
	}
	
	@Test(expected=NotificationLogicException.class) 
	public void testInvalidLimit() throws NotificationLogicException, NotificationCRUDException {
		long assocId = 5001;
		Notification notification = new Notification("100", "", 12, "", assocId, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
		notificationDAO.save(notification);
		viewService.get(assocId, 0, 3);
	}
	
	@Test(expected=NotificationLogicException.class) 
	public void testInvalidOffset() throws NotificationLogicException, NotificationCRUDException {
		long assocId = 5001;
		viewService.get(assocId, 1, 1);
	}
	
	@Test
	public void testGetLimitOffset() throws NotificationLogicException, NotificationCRUDException {
		long assocId = 5001;
		for (int i = 0; i < 1000; i++) {
			Notification notification = new Notification(String.valueOf(i), "", userId, "", assocId++, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
			notificationDAO.save(notification);
		}
		List<Notification> randomNotifications = viewService.get(userId, 0, 100);
		assertTrue(randomNotifications.size() == 100);
	}
	
	@Test
	public void testGet() throws NotificationLogicException, NotificationCRUDException {
		long assocId = 5001;
		Notification notification = new Notification("100", "", userId, "", assocId, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
		notificationDAO.save(notification);
		
		List<Notification> notifications = viewService.get(userId);
		
		assertTrue(notifications.size() == 1);
		assertTrue(notifications.get(0).getUserId() == userId);
	}
		
	@Test
	public void testEmptyGetAll() throws NotificationLogicException {
		List<Notification> notifications = viewService.get(userId);
		assertNotNull(notifications);
		assertEquals(0, notifications.size());
	}



}
