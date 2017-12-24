package com.tecsolvent.wizspeak.notification.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tecsolvent.wizspeak.notification.dao.NotFoundException;
import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.NotificationCRUDException;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAO;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAOImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class ViewNotificationServiceImplTest {
	
	@Autowired
	private ViewNotificationServiceImpl viewService;
	
	@Autowired
	private NotificationDAO notificationDAO;
	
	private static final long userId = 100000;

	@Test
	public void updateStatus() throws NotificationCRUDException, NotificationLogicException, NotFoundException {
		Notification notification = new Notification(Notification.NEW_ID, "", userId, "", 23, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
		notificationDAO.save(notification);
		viewService.updateStatus(notification.getId(), Notification.Status.UNREAD);
		notification = notificationDAO.get(notification.getId());
		assertEquals(Notification.Status.UNREAD, notification.getStatus());
	}
	
	@Test(expected=NotificationLogicException.class)
	public void updateNonExistentNotificationStatus() throws NotificationLogicException {
		viewService.updateStatus("eewqe", Notification.Status.READ);
	}
	
	@Test(expected=NotificationLogicException.class) 
	public void testInvalidLimit() throws NotificationLogicException, NotificationCRUDException {
		long assocId = 5001;
		Notification notification = new Notification(Notification.NEW_ID, "", userId, "", assocId, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
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
			Notification notification = new Notification(Notification.NEW_ID, "", userId, "", assocId++, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
			notificationDAO.save(notification);
		}
		List<Notification> randomNotifications = viewService.get(userId, 0, 100);
		assertTrue(randomNotifications.size() == 100);
	}
	
	@Test
	public void testGet() throws NotificationLogicException, NotificationCRUDException {
		long assocId = 5001;
		long userId = 123456787;
		Notification notification = new Notification(Notification.NEW_ID, "", userId, "", assocId, Notification.Status.READ, Notification.Type.COMMENT, Notification.Category.AMBITION);
		notificationDAO.save(notification);
		
		List<Notification> notifications = viewService.get(userId);
		
		assertTrue("Size didn't match.",notifications.size() == 1);
		assertTrue("User id didn't match", notifications.get(0).getUserId() == userId);
	}
		
	@Test
	public void testEmptyGetAll() throws NotificationLogicException {
		List<Notification> notifications = viewService.get(123452345);
		assertNotNull(notifications);
		assertEquals(0, notifications.size());
	}



}
