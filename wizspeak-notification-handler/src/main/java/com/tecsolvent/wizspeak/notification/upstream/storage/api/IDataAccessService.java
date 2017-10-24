package com.tecsolvent.wizspeak.notification.upstream.storage.api;

import java.util.List;

import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;

/**
 * this class would be point for storing and retrieving any data from underlying cache or database impl 
 *
 */
public interface IDataAccessService {
	/**
	 * get list of interested parties from cache
	 * @param postId
	 * @return list of users for given post id
	 * @throws InterestedPartiesHandlerException
	 */
	public List<String> getListOfInterestedParties(String postId) throws InterestedPartiesHandlerException;
	
	/**
	 * add new actor to the list of interested parties in cache after notification creation.
	 * 
	 * @param postId
	 * @param actorId
	 * @throws InterestedPartiesHandlerException
	 */
	public void addActorToInterestedParties( String postId, String actorId) throws InterestedPartiesHandlerException;
	
}
