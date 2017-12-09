package com.tecsolvent.wizspeak.notification.upstream.handler.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecsolvent.wizspeak.notification.dao.Notification.Type;
import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;
import com.tecsolvent.wizspeak.notification.upstream.handler.api.IWizspeakUpstreamHandler;
import com.tecsolvent.wizspeak.notification.upstream.storage.impl.KeyValueCache;

public class WizspeakUpstreamHandler implements IWizspeakUpstreamHandler {
	
	@Autowired
	private KeyValueCache keyValueCache;

	public void sendNotification(String actorId, long postId, Type notificationType, Map<String, String> msgContainer) {
		try {
			List<String> listOfExistingInterestedParties = keyValueCache.getAll(Long.toString(postId));
			Iterator<String> iteratorOfInterestedParties = listOfExistingInterestedParties.iterator();
			while( iteratorOfInterestedParties.hasNext() ) {
				String interestedPartyId = iteratorOfInterestedParties.next();
				// TODO: invoke create notification
			}
			keyValueCache.addActorToInterestedParties(Long.toString(postId), actorId);
		} catch (InterestedPartiesHandlerException e) {
			e.printStackTrace();
		}
		
	}

}
