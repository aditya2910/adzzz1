package com.tecsolvent.wizspeak.notification.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.tecsolvent.wizspeak.notification.dao.Notification.Category;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;

public class NotificationDAOImpl implements NotificationDAO {
	
	private Map<String, Notification> notificationCache = new HashMap<String, Notification>();
	private Map<String, LinkedHashMap<String, Notification>> userCache = new HashMap<String, LinkedHashMap<String, Notification>>();

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
		notificationCache.put(notification.getId(), notification);
		
		// update user cache.
		LinkedHashMap<String, Notification> notifications = userCache.get(userId);
		if (notifications == null) {
			notifications = new LinkedHashMap<String, Notification>();
		}
		
		notifications.put(notification.getSearchKey(), notification);
		userCache.put(userId, notifications);
		
		return notification.getId();
	}

	public void update(Notification notification) throws NotificationCRUDException {
		// TODO Auto-generated method stub		
	}

	public Notification get(long notificationId) throws NotFoundException {		
		return notificationCache.get(String.valueOf(notificationId));
	}

	public List<Notification> getAll(long userId) {	
		Map<String, Notification> userNotifications = userCache.get(String.valueOf(userId));
		List<Notification> notifications = userNotifications == null ? new ArrayList<Notification>() : new ArrayList<Notification>(userNotifications.values());
		return notifications;
	}
	
	public Notification get(long userId, Category category, long assocId, Type notificationType ) throws NotFoundException {
		String userIdStr = String.valueOf(userId);
		String assocIdStr = String.valueOf(assocId);
		Map<String, Notification> notifications = userCache.get(userIdStr);
		
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
