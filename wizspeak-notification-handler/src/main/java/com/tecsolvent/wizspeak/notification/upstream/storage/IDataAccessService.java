package com.tecsolvent.wizspeak.notification.upstream.storage;

import java.util.List;

/**
 * this class would be point for storing and retrieving any data from underlying cache or database impl 
 *
 */
public interface IDataAccessService {
	/**
	 * get list of interested parties from cache
	 * @param postId
	 * @return
	 */
	public List<String> getListOfInterestedParties(String postId);
	
	/**
	 * add new actor to the list of interested parties in cache after notification creation.
	 * 
	 * @param postId
	 * @param actorId
	 */
	public void addActorToInterestedParties( String postId, String actorId);
	
}
