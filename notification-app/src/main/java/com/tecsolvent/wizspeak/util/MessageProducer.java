package com.tecsolvent.wizspeak.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class MessageProducer {
	
	final static String TOPIC = Constants.TOPIC;
	
	// TODO: implement a callback to check if there was no error while publishing the message
	// https://github.com/gwenshap/kafka-examples/blob/master/SimpleCounter/src/main/java/com/shapira/examples/producer/simplecounter/DemoProducerNewJava.java
    public void sendMessgageToTopic(String postId, String msg){
        Properties properties = new Properties();
        properties.put("metadata.broker.list","localhost:9092");
        properties.put("serializer.class","kafka.serializer.StringEncoder");
        properties.put("client.id", "clientId001");
        ProducerConfig producerConfig = new ProducerConfig(properties);
        kafka.javaapi.producer.Producer<String,String> producer = new kafka.javaapi.producer.Producer<String, String>(producerConfig);
        SimpleDateFormat sdf = new SimpleDateFormat();
        KeyedMessage<String, String> message = new KeyedMessage<String, String>( TOPIC, sdf.format(new Date()) + "----" + msg );
        producer.send(message);
        
        System.out.println("Message sent.");
        producer.close();
    }
}
