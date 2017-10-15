package com.wizspeak.notification.upstream.storage;

import java.util.List;

/**
 * this class would be point for storing and retrieving any data from underlying cache or database impl 
 * @author 212410796
 *
 */
public interface ICacheMaster {
	public boolean addElements(String key, List<String> subsribers);
	public List<String> getAll(String key);
}
