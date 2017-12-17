package com.tecsolvent.wizspeak.notification.services;

import java.util.List;

import com.tecsolvent.wizspeak.notification.dao.NotFoundException;
import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.Notification.Status;
import com.tecsolvent.wizspeak.notification.dao.NotificationCRUDException;
import com.tecsolvent.wizspeak.notification.dao.NotificationDAO;

public class ViewNotificationServiceImpl implements ViewNotificationService {
	
	private NotificationDAO notificationDAO;

	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}

	public void updateStatus(String id, Status status) throws NotificationLogicException {
		try {
			Notification notification = notificationDAO.get(id);
			notification.setStatus(status);
			notificationDAO.save(notification);
		} catch (NotFoundException e) {
			throw new NotificationLogicException("Notification does not exist", e);
		} catch (NotificationCRUDException e) {
			throw new NotificationLogicException("Error in saving the notification", e);
		}
	}

	public List<Notification> get(long userId, int offset, int limit) throws NotificationLogicException {
		List<Notification> notifications;
		try {
			notifications = notificationDAO.getAll(userId).subList(offset, limit);		
		} catch (IndexOutOfBoundsException e) {
			throw new NotificationLogicException("Illegal range of notification.", e);
		}
		return notifications;
	}
	
	public List<Notification> get(long userId) throws NotificationLogicException {		
		return notificationDAO.getAll(userId);
	}

}
