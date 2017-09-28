package com.tecsolvent.wizspeak.infra.pool;

import java.util.List;
import java.util.Map;

import com.tecsolvent.wizspeak.infra.cache.api.KeyValueCache;
import com.tecsolvent.wizspeak.redis.impl.KeyValueRedisImpl;
import com.tecsolvent.wizspeak.util.Constants;

public class MessageProcessorRunnable implements Runnable{

	private Map<String,Object> msgMap;
	
	public MessageProcessorRunnable(Map<String, Object> msgMap) {
		super();
		this.msgMap = msgMap;
	}

	@Override
	public void run() {
		KeyValueCache keyValueCache = KeyValueRedisImpl.getInstance();
		//List<String> listOfSubs = keyValueCache.getAll(msgMap.get( Constants.POST_ID_KEY).toString() );
		//List<String> listOfSubs = keyValueCache.getAll( "111" );
		List<String> listOfSubs = keyValueCache.getAll( Constants.POST_ID_KEY );
		System.out.println("listOfSubs: " + listOfSubs);
		
		// TODO: push this message as notification to listOfSubs to UI
	}

}
