package com.tecsolvent.wizspeak.notification.services;

import java.util.List;
import java.util.Map;

import com.tecsolvent.wizspeak.notification.dao.NotFoundException;
import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.dao.Notification.Category;

/* Service class to handle CRUD operations for notifications.*/
public interface NotificationService {
	
	/**
	 * Creates or updates a notification.
	 * @param userId, user identifier 
	 * @param category, category of the notification
	 * @param postId, post identifier
	 * @param notificationType, type of notification to be generated.
	 * @param msgContainer, data map to construct the message.
	 * @return boolean
	 * @throws NotificationLogicException
	 */
  public void save(long userId, Category category, long postId, Notification.Type notificationType, Map<String, String> msgContainer) throws NotificationLogicException;

}
