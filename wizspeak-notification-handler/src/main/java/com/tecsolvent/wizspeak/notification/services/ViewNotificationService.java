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
	 * @param id, notification identifier.
	 * @param status, status of notification.
	 * @return boolean
	 * @throws NotificationLogicException
	 */
	public boolean updateStatus(long id, Notification.Status status) throws NotificationLogicException;
	// TODO: change id to meaningful name
	// this will be unsupported for now.
	
	
	/**
	 * Retrieves notifications of given user.
	 * @param userId, user identifier
	 * @param actorId
	 * @param offset, index of the notification.
	 * @param limit, number of notification required.
	 * @return list of notification based on limit and offset.
	 * @throws NotificationLogicException
	 */
	public List<Notification> get(long userId, long actorId, long offset, long limit) throws NotificationLogicException;

}
