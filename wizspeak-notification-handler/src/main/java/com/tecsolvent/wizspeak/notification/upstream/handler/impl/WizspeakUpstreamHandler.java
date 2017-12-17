package com.tecsolvent.wizspeak.notification.upstream.handler.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import com.tecsolvent.wizspeak.notification.dao.Notification.Category;
import com.tecsolvent.wizspeak.notification.dao.Notification.Type;
import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;
import com.tecsolvent.wizspeak.notification.services.NotificationLogicException;
import com.tecsolvent.wizspeak.notification.services.NotificationService;
import com.tecsolvent.wizspeak.notification.upstream.handler.api.IWizspeakUpstreamHandler;
import com.tecsolvent.wizspeak.notification.upstream.storage.impl.KeyValueCache;

public class WizspeakUpstreamHandler implements IWizspeakUpstreamHandler {
	
	@Autowired
	private KeyValueCache keyValueCache;
	
	@Autowired 
	private NotificationService notificationService;

	public void sendNotification(long userId, Category category, long actorId, long postId, Type notificationType, Map<String, String> msgContainer, boolean isActorSubscriber) {

		try {
			Set<String> setOfExistingInterestedParties = keyValueCache.getAll(Long.toString(postId));
			
			setOfExistingInterestedParties.forEach(ip -> {
				try {
					notificationService.save( Long.parseLong(ip), category, postId, notificationType, msgContainer);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (NotificationLogicException e) {
					e.printStackTrace();
				}
			});
			
			if(!setOfExistingInterestedParties.contains(Long.toString(userId)) ) {
				keyValueCache.addActorToInterestedParties(Long.toString(postId), Long.toString(userId));
			}
			if( isActorSubscriber ) {
				keyValueCache.addActorToInterestedParties(Long.toString(postId), Long.toString(actorId));
			}
		} catch (InterestedPartiesHandlerException e) {
			e.printStackTrace();
		}
		
	}

}
