package com.tecsolvent.wizspeak.notification.upstream.storage.impl;

import java.util.List;
import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;
import com.tecsolvent.wizspeak.notification.upstream.storage.api.IKeyValueCache;

public class KeyValueCache implements IKeyValueCache {
	
	private static RedissonClient redisson = null;
	String redisHost = null;
	String redisPort = null;
	
	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

	public String getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(String redisPort) {
		this.redisPort = redisPort;
	}

	

	public void initIt() throws Exception {
		Config config = new Config();
		System.out.println("redis: " + redisHost + ":" + redisPort );
     	config.useSingleServer().setAddress( redisHost + ":" + redisPort );
        redisson = Redisson.create(config);
	}

	public boolean addElements(String key, List<String> subsribers) throws InterestedPartiesHandlerException {
		System.out.println( "redisson: " + redisson );
		return false;
	}

	public List<String> getAll(String key) throws InterestedPartiesHandlerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// TODO: add below methods to IKeyValueCache when they are discussed to be fine
	public void addNotificationObjectsToStore(String key, Notification notification) throws InterestedPartiesHandlerException {
		RBucket<Notification> bucket = redisson.getBucket(key);
		bucket.set(notification);
	}
	
	public Notification getNotificationObjectsFromStore(String key) throws InterestedPartiesHandlerException {
		RBucket<Notification> bucket = redisson.getBucket(key);
		return bucket.get();
	}
	
	public void addNotificationsMapToStore(String key, Map<String,Notification> mapOfNotifications) throws InterestedPartiesHandlerException {
		RMap<String, Notification> rmap = redisson.getMap(key);
		rmap.putAll(mapOfNotifications);
	}
	
	public Map<String,Notification> getNotificationsMapFromStore(String key, Map<String,Notification> mapOfNotifications) throws InterestedPartiesHandlerException {
		//https://github.com/redisson/redisson/wiki/7.-Distributed-collections
		return null;
	}

}
