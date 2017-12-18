package com.tecsolvent.wizspeak.notification.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecsolvent.wizspeak.notification.dao.NotFoundException;
import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.Notification.Category;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;
import com.tecsolvent.wizspeak.notification.dao.NotificationCRUDException;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAO;

public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDAO notificationDAO;

	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}

	public void save(long userId, Category category, long assocId, Type notificationType,
			Map<String, String> msgContainer) throws NotificationLogicException {
		
		// validate args.
		if (userId <= 0 || category == null || assocId <= 0 || notificationType == null || msgContainer == null) {
			throw new IllegalArgumentException("Invalid arguments.");
		}		
		
		String notificationId = Notification.NEW_ID;
		try {
			 Notification savedNotification = notificationDAO.get(userId, category, assocId, notificationType);
			 notificationId = savedNotification.getId();
		} catch (NotFoundException e) {
			
		}
		
		
		// TODO update the notification message.
		
		Notification notification = new Notification(notificationId, "", userId, getMessage(notificationType), assocId, Notification.Status.UNREAD, notificationType, category);
		try {
			notificationDAO.save(notification);
		} catch (NotificationCRUDException e) {
			throw new NotificationLogicException("Error in saving notification.", e);
		}
	}
	
	private String getMessage(Notification.Type notificationType) {
		StringBuilder msg = new StringBuilder("Some user ");
		switch(notificationType) {
		case COMMENT:
			msg.append("commented.");
			break;
		case FRND_REQ:
			msg.append("send friend request.");
			break;
		case LIKE:
			msg.append("liked.");
			break;
		default:
			break;
		
		}
		return msg.toString();
	}
	
}
