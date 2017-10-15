package com.wizspeak.notification.upstream.storage;

import java.util.List;

/**
 * this class would be point for storing and retrieving any data from underlying cache or database impl 
 *
 */
public interface ICacheMaster {
	/**
	 * get list of interested parties from cache
	 * @param postId
	 * @return
	 */
	public List<String> getListOfInterestedPartiesFromCache(String postId);
	
	/**
	 * add new actor to the list of interested parties in cache after notification creation.
	 * 
	 * @param key
	 * @param subsribers
	 */
	public void addElements( String postId, String actorId);
	
}
