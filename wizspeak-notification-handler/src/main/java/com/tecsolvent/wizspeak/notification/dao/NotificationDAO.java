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
	 * update delta of notification
	 * 
	 * @param notification
	 * @return boolean.
	 * @throws NotificationCRUDException
	 */
	public boolean update(Notification notification) throws NotificationCRUDException;

	// TODO: have delete API with unsupported impl for now.
	
}
