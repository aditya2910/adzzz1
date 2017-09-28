package com.tecsolvent.wizspeak.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsolvent.wizspeak.infra.model.Message;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class MessageProducer {
	
	final static String TOPIC = Constants.TOPIC;
	
	// TODO: implement a callback to check if there was no error while publishing the message
	// https://github.com/gwenshap/kafka-examples/blob/master/SimpleCounter/src/main/java/com/shapira/examples/producer/simplecounter/DemoProducerNewJava.java
    public void sendMessgageToTopic(String postId, String msg) throws JsonProcessingException{
        Properties properties = new Properties();
        properties.put("metadata.broker.list","localhost:9092");
        properties.put("serializer.class","kafka.serializer.StringEncoder");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("client.id", "clientId001");
        ProducerConfig producerConfig = new ProducerConfig(properties);
        
        Message msgObj = new Message("test-id", "test-msg");
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(msgObj);
        
        kafka.javaapi.producer.Producer<String,String> producer = new kafka.javaapi.producer.Producer<String, String>(producerConfig);
        KeyedMessage<String, String> message =new KeyedMessage<String, String>(TOPIC, jsonInString );
        producer.send(message);
        
        System.out.println("Message sent.");
        producer.close();
    }
   
}
