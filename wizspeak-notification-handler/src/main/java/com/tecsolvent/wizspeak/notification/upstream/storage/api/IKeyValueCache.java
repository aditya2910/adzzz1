package com.tecsolvent.wizspeak.notification.upstream.storage.api;

import java.util.List;

import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;

/**
 * this interface is for handling data store and retrieve to redis
 * @author adityakumar
 *
 */
public interface IKeyValueCache {
	
	public boolean addElements(String key, List<String> subsribers) throws InterestedPartiesHandlerException;
	
	public List<String> getAll(String key) throws InterestedPartiesHandlerException;
	
}
