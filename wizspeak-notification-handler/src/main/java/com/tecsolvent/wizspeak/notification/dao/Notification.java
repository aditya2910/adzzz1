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
	
	/* Category of the notification. */
	private Category category;
	
	/**
	 * Constructor
	 * @param id
	 * @param picUrl
	 * @param message
	 * @param status
	 * @param dateAdded
	 * @param dateModified
	 * @param type
	 * @param category
	 */
	public Notification(long id, String picUrl, String message, Status status, Date dateAdded, Date dateModified, Type type, Category category) {
		
		setId(id);
		setPicUrl(picUrl);
		setMessage(message);
		setStatus(status);
		setDateAdded(dateAdded);
		setDateModified(dateModified);
		setType(type);
		setCategory(category);		
	}
	
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
	
	/* Different categories */
	public enum Category {
		AMBITION(0),
		HOBBIES(1),
		TEAMS(2);
		
		private int value;
		
		private Category(int value) {
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
	
	public Category getCategory() {
		return category;
	}

	private void setId(long id) {
		this.id = id;
	}

	private void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	private void setStatus(Status status) {
		this.status = status;
	}

	private void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	private void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	private void setType(Type type) {
		this.type = type;
	}

	private void setCategory(Category category) {
		this.category = category;
	}

}
