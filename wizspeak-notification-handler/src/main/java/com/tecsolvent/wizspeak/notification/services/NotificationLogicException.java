package com.tecsolvent.wizspeak.notification.services;

/* Wraps business logic errors related to notification. */
public class NotificationLogicException extends Exception {
	
	public NotificationLogicException(String msg, Exception e) {
		super(msg, e);
	}

}
