package com.tecsolvent.wizspeak.redis.impl;

import java.util.ArrayList;
import java.util.List;

import org.redisson.Redisson;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import com.tecsolvent.wizspeak.infra.cache.api.KeyValueCache;
import com.tecsolvent.wizspeak.util.StringUtils;

public class KeyValueRedisImpl implements KeyValueCache {
	private static RedissonClient redisson = null;
	private static final KeyValueRedisImpl INSTANCE = new KeyValueRedisImpl();
	
	static{
		// should be config driven later.
		Config config = new Config();
    	//config.setUseLinuxNativeEpoll(true);
    	config.useSingleServer()
    	       // use "rediss://" for SSL connection
    	      .setAddress("139.162.33.112:6379");
        // connects to 127.0.0.1:6379 by default
        redisson = Redisson.create(config);
	}
	
	private KeyValueRedisImpl(){
		
	}
	
	public static KeyValueRedisImpl getInstance(){
		return INSTANCE;
	}
	
	public static RedissonClient create(){
        return redisson;
	}
	@Override
	public boolean addElements(String key, List<String> subsribers) {
		if(StringUtils.isEmpty(key)){
			throw new RuntimeException("key cannot be null/empty!!");
		}
		RSet<String> set1 = redisson.getSet(key);
		return set1.addAll(subsribers);
	}

	@Override
	public List<String> getAll(String key) {
		if(StringUtils.isEmpty(key)){
			throw new RuntimeException("key cannot be null/empty!!");
		}
		RSet<String> set1 = redisson.getSet(key);
		List<String> subscribers = new ArrayList<String>();
		if(set1 != null && !set1.isEmpty()){
			for(String subscriber : set1){
				subscribers.add(subscriber);
			}
		}
		return subscribers;
	}

	public static void main(String[] args) {
		KeyValueCache kvCache = new KeyValueRedisImpl();
		List<String> list1 = kvCache.getAll("1");
		System.out.println("before list1 - " + list1);
		List<String> subscribers = new ArrayList<>();
		subscribers.add("Anurag4");
		subscribers.add("Anurag5");
		kvCache.addElements("1", subscribers);
		List<String> list2 = kvCache.getAll("1");
		System.out.println("after list2 - " + list2);
	}
}
