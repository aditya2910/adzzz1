package com.tecsolvent.wizspeak.notification.upstream.storage.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import com.tecsolvent.wizspeak.notification.dao.Notification;
import com.tecsolvent.wizspeak.notification.exception.InterestedPartiesHandlerException;
import com.tecsolvent.wizspeak.notification.upstream.storage.api.IKeyValueCache;
import com.tecsolvent.wizspeak.notification.util.StringUtils;

public class KeyValueCache implements IKeyValueCache {
	
	private static RedissonClient redisson = null;
	private String redisHost = null;
	private String redisPort = null;
	
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
		if(StringUtils.isEmpty(key)){
			throw new InterestedPartiesHandlerException("key cannot be null/empty!!");
		}
		RSet<String> rset = redisson.getSet(key);
		return rset.addAll(subsribers);
	}
	
	public boolean addActorToInterestedParties(String key, String actorId) throws InterestedPartiesHandlerException {
		if(StringUtils.isEmpty(key)){
			throw new InterestedPartiesHandlerException("key cannot be null/empty!!");
		}
		RSet<String> rset = redisson.getSet(key);
		return rset.add(actorId);
	}

	public Set<String> getAll(String key) throws InterestedPartiesHandlerException {
		if(StringUtils.isEmpty(key)){
			throw new InterestedPartiesHandlerException("key cannot be null/empty!!");
		}
		RSet<String> rset = redisson.getSet(key);
		Set<String> subscribers = new HashSet<String>();
		if(rset != null && !rset.isEmpty()){
			for(String subscriber : rset){
				subscribers.add(subscriber);
			}
		}
		return subscribers;
	}
	
	// TODO: add below methods to IKeyValueCache when they are discussed to be fine. Is all get methods fine ?
	public void addNotification(String key, Notification notification) {
		RBucket<Notification> bucket = redisson.getBucket(key);
		bucket.set(notification);
	}
	
	public Notification getNotification(String key) {
		RBucket<Notification> bucket = redisson.getBucket(key);
		return bucket.get();
	}
	
	public void addNotificationsMap(String key, Map<String,Notification> mapOfNotifications) {
		RBucket< Map<String, Notification>> bucket = redisson.getBucket(key);
		bucket.set(mapOfNotifications);
	}
	
	public Map<String,Notification> getNotificationsMap(String key) {
		//https://github.com/redisson/redisson/wiki/7.-Distributed-collections
		RBucket< Map<String, Notification>> bucket = redisson.getBucket(key);
		return bucket.get();
	}

}
