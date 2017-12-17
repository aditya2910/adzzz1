package com.tecsolvent.wizspeak.notification.upstream.handler.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecsolvent.wizspeak.notification.dao.Notification;
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

	public void sendNotification(String actorId, Notification.Category notificationCategory, long postId, Type notificationType, Map<String, String> msgContainer, boolean isActorSubscriber) {
		try {
			List<String> listOfExistingInterestedParties = keyValueCache.getAll(Long.toString(postId));
			Iterator<String> iteratorOfInterestedParties = listOfExistingInterestedParties.iterator();
			//TODO: 
			while( iteratorOfInterestedParties.hasNext() ) {
				String interestedPartyId = iteratorOfInterestedParties.next();
				try {
					notificationService.save(postId, notificationCategory, postId, notificationType, msgContainer);
				} catch (NotificationLogicException e) {
					e.printStackTrace();
				}
			}
			if( isActorSubscriber ) {
				keyValueCache.addActorToInterestedParties(Long.toString(postId), actorId);
			}
		} catch (InterestedPartiesHandlerException e) {
			e.printStackTrace();
		}
		
	}

}
