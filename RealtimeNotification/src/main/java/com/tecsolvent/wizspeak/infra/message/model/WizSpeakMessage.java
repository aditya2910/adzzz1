package com.tecsolvent.wizspeak.infra.message.model;

public class WizSpeakMessage {
	String userId;
	String timeStamp;
	String messageType;
	String messageContent;
	
	public WizSpeakMessage(String userId, String timeStamp, String messageType, String messageContent) {
		this.userId = userId;
		this.timeStamp = timeStamp;
		this.messageType = messageType;
		this.messageContent = messageContent;
	}
	public String getUserId() {
		return userId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public String getMessageType() {
		return messageType;
	}
	public String getMessageContent() {
		return messageContent;
	}
	
	
	
}
