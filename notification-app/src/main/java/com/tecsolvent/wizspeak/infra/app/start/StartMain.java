package com.tecsolvent.wizspeak.infra.app.start;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tecsolvent.wizspeak.infra.cache.api.KeyValueCache;
import com.tecsolvent.wizspeak.redis.impl.KeyValueRedisImpl;
import com.tecsolvent.wizspeak.util.Constants;
import com.tecsolvent.wizspeak.util.MessageConsumer;
import com.tecsolvent.wizspeak.util.MessageProducer;

public class StartMain {
	
	static{
		MessageConsumer helloKafkaConsumer = new MessageConsumer();
        helloKafkaConsumer.start();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException, JsonProcessingException {
		// register 3 browser sessions in cache
		KeyValueCache keyValueCache = KeyValueRedisImpl.getInstance();
		List<String> list1 = keyValueCache.getAll("111");
		System.out.println("before list1 - " + list1);
		
		List<String> listOfSubscriber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			listOfSubscriber.add( Long.toString(System.currentTimeMillis()) + Integer.toString(i) );
		}
		//keyValueCache.addElements( Long.toString(System.currentTimeMillis()), listOfSubscriber );
		//keyValueCache.addElements( "111", listOfSubscriber );
		keyValueCache.addElements( Constants.POST_ID_KEY, listOfSubscriber );
		System.out.println("Stored in redis successfully.");
		
		MessageProducer msgProducer = new MessageProducer();
		msgProducer.sendMessgageToTopic( "test-postId", "Hello World !" );
				
	}

}
