package com.tecsolvent.wizspeak.notification.upstream.storage.impl;

import java.util.List;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

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

}
