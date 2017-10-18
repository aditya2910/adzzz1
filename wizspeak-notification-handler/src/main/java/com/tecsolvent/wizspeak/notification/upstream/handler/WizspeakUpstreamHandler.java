package com.tecsolvent.wizspeak.notification.upstream.handler;

import java.util.Map;

import com.tecsolvent.wizspeak.notification.dao.Notification;

/**
 * this interface specifies contract for upstream to identify interested parties for given post_id
 *
 */
public interface WizspeakUpstreamHandler {
	
	/**
	 * this method would get interested parties from cache for given post id
	 * and iterate though the list of interested parties and invoke create notification 
	 * ( NotificationService - create )
	 * After iteration, add the new user/actor to interested parties list
	 * 
	 * @param userId
	 * @param actorId
	 * @param postId
	 * @param notificationType
	 * @param notificationMessage
	 */
	void sendNotification( String actorId, long postId, 
			Notification.Type notificationType, Map<String,String> notificationMessage );
	
}
