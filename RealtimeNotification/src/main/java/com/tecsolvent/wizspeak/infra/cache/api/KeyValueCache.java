package com.tecsolvent.wizspeak.infra.cache.api;

import java.util.List;

/**
 * {@link KeyValueCache} is used to store list of subscribers against a key.
 * 
 * @author anurag saxena
 *
 * @param <K>
 * @param <V>
 */
public interface KeyValueCache {
	public boolean addElements(String key, List<String> subsribers);
	public List<String> getAll(String key);
}
