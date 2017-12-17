package com.tecsolvent.wizspeak.notification.dao;

import java.util.List;

import com.tecsolvent.wizspeak.notification.dao.Notification.Category;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;

/**
 * Contract for Data access handler for notifications. * 
 * @author vikash kumar
 * 
 */
public interface NotificationDAO {
	
	/**
	 * Saves a notification.
	 * @param notification
	 * @return notification identifier.
	 * @throws NotificationCRUDException
	 */
	public String save(Notification notification) throws NotificationCRUDException;	
	
	/**
	 * @param notificationId, notification identifier
	 * @return notification
	 */
	public Notification get(String notificationId) throws NotFoundException;
	
	/**
	 * @param userId, user identifier
	 * @return list of notification for the user
	 */
	public List<Notification> getAll(long userId);
	
	/**
	 * @param userId, user identifier
	 * @param category, notification category
	 * @param assocId, associated entity identifier
	 * @param notificationType, notification type
	 * @return notification object
	 * @throws NotFoundException
	 */
	public Notification get(long userId, Category category, long assocId, Type notificationType ) throws NotFoundException;

	
}
