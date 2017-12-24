package com.tecsolvent.wizspeak.notification.upstream.handler.impl;

import java.util.Map;
import java.util.Set;

import com.tecsolvent.wizspeak.notification.dao.Notification.Category;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;
import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;
import com.tecsolvent.wizspeak.notification.services.NotificationLogicException;
import com.tecsolvent.wizspeak.notification.services.NotificationService;
import com.tecsolvent.wizspeak.notification.upstream.handler.api.IWizspeakUpstreamHandler;
import com.tecsolvent.wizspeak.notification.upstream.storage.impl.KeyValueCache;

public class WizspeakUpstreamHandler implements IWizspeakUpstreamHandler {
	
	private KeyValueCache keyValueCache;	
	private NotificationService notificationService;
	
	public void setKeyValueCache(KeyValueCache keyValueCache) {
		this.keyValueCache = keyValueCache;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void sendNotification(long userId, Category category, long actorId, long postId, Type notificationType, Map<String, String> msgContainer, boolean isActorSubscriber) {

		try {
			Set<String> setOfExistingInterestedParties = keyValueCache.getAll(Long.toString(postId));
			setOfExistingInterestedParties.add(String.valueOf(userId));
			
			for (String ip : setOfExistingInterestedParties) {
				try {
					notificationService.save( Long.parseLong(ip), category, postId, notificationType, msgContainer);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (NotificationLogicException e) {
					e.printStackTrace();
				}
			}			
			
			if( isActorSubscriber ) {
				keyValueCache.addActorToInterestedParties(Long.toString(postId), Long.toString(actorId));
			}
		} catch (InterestedPartiesHandlerException e) {
			e.printStackTrace();
		}
		
	}

}
