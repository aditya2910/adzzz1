package com.tecsolvent.wizspeak.infra.message.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import com.tecsolvent.wizspeak.infra.message.model.WizSpeakMessage;

public class WizSpeakMessagePublisher {

	private static String TOPIC_NAME = "my-topic";
	
	public static void main(String[] args) {
		publishMessage( "userId1", "timeStamp1", "messageType1", "messageContent1" );
	}

	// remove main and static keywords from method
	public static void publishMessage( String userId, String timeStamp, String messageType, String messageContent ) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);

		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, userId, getMessageTobePublished(userId, timeStamp,
				messageType, messageContent));
		producer.send(record);

		producer.close();
	}

	private static String getMessageTobePublished(String userId, String timeStamp, String messageType, String messageContent) {
		WizSpeakMessage message = new WizSpeakMessage(userId, timeStamp, messageType, messageContent);
		JSONObject jsonObject = new JSONObject(message);
		String myJson = jsonObject.toString();
		System.out.println( "myJson: " + myJson );
		return myJson;
	}


}
