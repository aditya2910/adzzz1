package com.tecsolvent.wizspeak.notification.dao;


/**
 * Contract for Data access handler for notifications. * 
 * @author vikash kumar
 * 
 */
public interface NotificationDAO {
	
	/**
	 * Creates a notification.
	 * @param notification
	 * @return notification identifier.
	 * @throws NotificationCRUDException
	 */
	public long create(Notification notification) throws NotificationCRUDException;
	
	/**
	 * Updates the notificaiton. 
	 * 
	 * @param notification
	 * @throws NotificationCRUDException
	 */
	public void update(Notification notification) throws NotificationCRUDException;

}
