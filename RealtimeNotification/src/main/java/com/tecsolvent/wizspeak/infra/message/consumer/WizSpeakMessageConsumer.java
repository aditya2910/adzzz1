package com.tecsolvent.wizspeak.infra.message.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.tecsolvent.wizspeak.infra.cache.api.KeyValueCache;
import com.tecsolvent.wizspeak.infra.message.model.WizSpeakMessage;
import com.tecsolvent.wizspeak.redis.impl.KeyValueRedisImpl;

public class WizSpeakMessageConsumer {
	
	private static String TOPIC_NAME = "my-topic";

	public void onMessage(WizSpeakMessage message) {
		Properties props = getConsumerProperties();
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList( TOPIC_NAME ));
		
		while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records){
	        	 System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
	        	 KeyValueCache keyValueCache = KeyValueRedisImpl.getInstance();
	        	 List<String> listOfInterceptParties = keyValueCache.getAll(TOPIC_NAME);
	        	 listOfInterceptParties.add(message.toString());
	        	 keyValueCache.addElements( TOPIC_NAME, listOfInterceptParties );
	         }
		}
	}

	private Properties getConsumerProperties() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		return props;
	}

}
