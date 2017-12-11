package com.tecsolvent.wizspeak.notification.services;

import java.util.List;

import com.tecsolvent.wizspeak.notification.dao.Notification;

/* 
 * Contract for user interface related clients. 
 * Implementation class should delegate it's notification related tasks to NotificationService.
 * 
 */
public interface ViewNotificationService {
	
	/**
	 * Update notification status
	 * @param notificationId, notification identifier.
	 * @param status, status of notification.
	 * @return boolean
	 * @throws NotificationLogicException
	 */
	public void updateStatus(String notificationId, Notification.Status status) throws NotificationLogicException;
	
	
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
