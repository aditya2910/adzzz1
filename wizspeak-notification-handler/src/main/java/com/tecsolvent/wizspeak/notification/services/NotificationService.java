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

	
	/**
	 * Updates a notification. 
	 * Note :- Null values should be ignored.
	 * @param notification, notification object
	 * @return boolean
	 * @throws NotificationLogicException
	 */
	public void update(Notification notification) throws NotificationLogicException;	
	
	
	/**
	 * Retrieves notifications of given user.
	 * @param userId, user identifier
	 * @param offset, index of the notification.
	 * @param limit, number of notification required.
	 * @return list of notification based on limit and offset.
	 * @throws NotificationLogicException
	 */
	public List<Notification> get(long userId, int offset, int limit) throws NotificationLogicException;
	
	/**
	 * Retrieves all notifications of the user.
	 * @param userId, user identifier.
	 * @return list of all notification for the given user.
	 * @throws NotificationLogicException
	 */
	public List<Notification> get(long userId) throws NotificationLogicException;

}
