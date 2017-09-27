package com.tecsolvent.wizspeak.util;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsolvent.wizspeak.infra.pool.MessageProcessorRunnable;

public class MessageConsumer extends  Thread {
    final static String clientId = "SimpleConsumerDemoClient";
    ConsumerConnector consumerConnector;
    
    ExecutorService executorService = Executors.newFixedThreadPool(Constants.MESSAGE_PROCESSING_THREAD_POOL_SIZE);


    public MessageConsumer(){
        Properties properties = new Properties();
        properties.put("zookeeper.connect","localhost:2181");
        properties.put("group.id", "test-group");
        properties.put("client.id", "clientId001");
        ConsumerConfig consumerConfig = new ConsumerConfig(properties);
        consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
    }

    @Override
    public void run() {
    	Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(Constants.TOPIC, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream =  consumerMap.get(Constants.TOPIC).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while(it.hasNext()){
			String msg = new String(it.next().message() );
			System.out.println("msg: " + msg);
			ObjectMapper mapper = new ObjectMapper();
			try {
				Map<String,Object> msgMap = mapper.readValue(msg, Map.class);
				System.out.println("map: "+ msgMap);
				
				executorService.execute(new MessageProcessorRunnable(msgMap));

				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    }

    }

}
