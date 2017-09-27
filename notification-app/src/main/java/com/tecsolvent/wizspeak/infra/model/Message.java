package com.tecsolvent.wizspeak.infra.model;

public class Message {
	String postId;
	String msg;
	
	public Message(String postId, String msg) {
		super();
		this.postId = postId;
		this.msg = msg;
	}

	public String getPostId() {
		return postId;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
