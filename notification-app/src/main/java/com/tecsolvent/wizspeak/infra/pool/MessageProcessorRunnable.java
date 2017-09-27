package com.tecsolvent.wizspeak.infra.pool;

import java.util.Map;

public class MessageProcessorRunnable implements Runnable{

	private Map<String,Object> msgMap;
	
	public MessageProcessorRunnable(Map<String, Object> msgMap) {
		super();
		this.msgMap = msgMap;
	}

	@Override
	public void run() {
		// TODO - get list of subscribers from redis and send msg to them except sender
		System.out.println("TODO - get list of subscribers from redis and send msg to them except sender");
		
	}

}
