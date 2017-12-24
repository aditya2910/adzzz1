package com.tecsolvent.wizspeak.notification.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.tecsolvent.wizspeak.notification.dao.Notification.Category;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;
import com.tecsolvent.wizspeak.notification.services.NotificationService;
import com.tecsolvent.wizspeak.notification.upstream.storage.impl.KeyValueCache;

public class NotificationDAOImpl implements NotificationDAO {
	
	private KeyValueCache notificationCache;	
	
	public void setKeyValueCache(KeyValueCache cache) {
		this.notificationCache = cache;
	}

	public String save(Notification notification) throws NotificationCRUDException {
		
		if (notification == null) {
			throw new IllegalArgumentException("Notification object can't be null.");
		}
		
		if (Notification.NEW_ID.equals(notification.getId())) {
			notification.setId(getRandomId());
			notification.setDateAdded(getCurrentDate());
		}
		
		String userId = String.valueOf(notification.getUserId());
		
		notification.setDateModified(getCurrentDate());
		notificationCache.addNotification(notification.getId(), notification);
		
		// update user cache.
		LinkedHashMap<String, Notification> notifications = (LinkedHashMap<String, Notification>) notificationCache.getNotificationsMap(userId);
		if (notifications == null) {
			notifications = new LinkedHashMap<String, Notification>();
		}
		
		notifications.put(notification.getSearchKey(), notification);
		notificationCache.addNotificationsMap(userId, notifications);
		
		return notification.getId();
	}	
	
	public Notification get(String notificationId) throws NotFoundException {	
		Notification notification = notificationCache.getNotification(notificationId);
		
		if (notification == null) {
			throw new NotFoundException("Notification does not exist");
		}
		
		return notification;
	}

	public List<Notification> getAll(long userId) {	
		Map<String, Notification> userNotifications = (LinkedHashMap<String, Notification>) notificationCache.getNotificationsMap(String.valueOf(userId));
		List<Notification> notifications = userNotifications == null ? new ArrayList<Notification>() : new ArrayList<Notification>(userNotifications.values());
		return notifications;
	}
	
	public Notification get(long userId, Category category, long assocId, Type notificationType ) throws NotFoundException {
		String userIdStr = String.valueOf(userId);
		String assocIdStr = String.valueOf(assocId);
		Map<String, Notification> notifications = notificationCache.getNotificationsMap(userIdStr);
		
		if (notifications == null) {
			throw new NotFoundException("Could not find the notification.");
		}
		
		String searchKey = Notification.getSearchKey(userIdStr, assocIdStr, category, notificationType);
		Notification notification = notifications.get(searchKey);
		if (notification == null) {
			throw new NotFoundException("Could not find the notification.");
		}
		
		return notification;
	}
	
	String getRandomId() {
		return UUID.randomUUID().toString();
	}
	
	private Date getCurrentDate() {
		Date date = new Date();
		//String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		return date;
	}

}
