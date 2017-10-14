package com.wizspeak.notification.upstream.handler;

import com.wizspeak.notification.upstream.util.Type;

/**
 * this interface specifies contract to for upstream to identify interested parties for given post_id
 *
 */
public interface WizspeakUpstreamHandler {
	
	/**
	 * this method would get interested parties from cache for given post id
	 * and iterate though the list of interested parties and invoke create notification 
	 * After iteration, add the new user/actor to interested parties list
	 * 
	 * @param userId
	 * @param actorId
	 * @param postId
	 * @param notificationType
	 * @param notificationMessage
	 */
	void createNotificationForInterestedParties( String userId, String actorId, long postId, 
			Type notificationType, String notificationMessage );
	
}
