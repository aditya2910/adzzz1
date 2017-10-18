package com.tecsolvent.wizspeak.notification.dao;

import java.util.Date;

/* Model class for notifications. */
public class Notification {
	
	/* notification identifier */
	private long id;
	
	/* picture associated with the notification. */
	private String picUrl;
	
	/* notification message */
	private String message;
	
	/* notification status */
	private Status status;
	
	/* stores when the record was created. */
	private Date dateAdded;
	
	/* stores when the record was last updated. */
	private Date dateModified;
	
	/* type of the notification. */
	private Type type;
	
	
	// TODO: need both setter and getter for status
	/* Enum to hold different state/status of the notification. */
	public enum Status {
		
		READ(0), 
		UNREAD(1);
		
		/**
		 * @param value integer to represent the enum in database.
		 */
		private Status(int value) {
			this.value = value;
		}
		
		private int value;
		
		/**
		 * @return value.
		 */
		public int getValue() {
			return value;
		}

	}
	
	public enum Type {
		LIKE(0), //	 likes
		COMMENT(1), // comments
		FRND_REQ(2); // friend requests
		
		private int value;
		
		private Type(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}



	public long getId() {
		return id;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public String getMessage() {
		return message;
	}

	public Status getStatus() {
		return status;
	}

	public Date getDateAdded() {
		return dateAdded;
	}
	
	public Date getDateModified() {
		return dateModified;
	}

	public Type getType() {
		return type;
	}

}
