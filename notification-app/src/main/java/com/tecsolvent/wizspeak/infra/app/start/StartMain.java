package com.tecsolvent.wizspeak.infra.app.start;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tecsolvent.wizspeak.infra.cache.api.KeyValueCache;
import com.tecsolvent.wizspeak.redis.impl.KeyValueRedisImpl;
import com.tecsolvent.wizspeak.util.MessageConsumer;
import com.tecsolvent.wizspeak.util.MessageProducer;

public class StartMain {

	public static void main(String[] args) throws InterruptedException, JsonProcessingException {
		// register 3 browser sessions in cache
		KeyValueCache keyValueCache = KeyValueRedisImpl.getInstance();
		List<String> listOfSubscriber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			listOfSubscriber.add( Long.toString(System.currentTimeMillis()) + Integer.toString(i) );
		}
		keyValueCache.addElements( Long.toString(System.currentTimeMillis()), listOfSubscriber );
		
		MessageProducer msgProducer = new MessageProducer();
		msgProducer.sendMessgageToTopic( "test-postId", "Hello World !" );
		
		Thread.sleep(1000);
		
		MessageConsumer helloKafkaConsumer = new MessageConsumer();
        helloKafkaConsumer.start();
		
	}

}
