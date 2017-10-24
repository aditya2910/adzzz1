package com.tecsolvent.wizspeak.notification.upstream.storage.api;

import java.util.List;

import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;

public interface IKeyValueCache {
	
	public boolean addElements(String key, List<String> subsribers) throws InterestedPartiesHandlerException;
	
	public List<String> getAll(String key) throws InterestedPartiesHandlerException;
	
}
