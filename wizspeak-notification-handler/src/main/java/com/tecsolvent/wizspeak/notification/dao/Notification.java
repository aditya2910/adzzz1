package com.tecsolvent.wizspeak.notification.dao;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.tecsolvent.wizspeak.notification.util.ValidationUtil;

/* Model class for notifications. */
public class Notification {
	
	/* Dummy id to represent new object. */
	public static final String NEW_ID = "NEW_ID";
	
	/* notification identifier */
	private String id;
	
	/* identifier of entity with which notification is associated with. */
	private long associationId;
	
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
	
	/* user identifier for whom notification belongs */
	private long userId;
	
	/**
	 * Default constructor
	 */
	public Notification() {
		setId(NEW_ID);
	}	
	
	/**
	 * @param id
	 * @param picUrl
	 * @param userId
	 * @param message
	 * @param associationId
	 * @param status
	 * @param type
	 * @param category
	 */
	public Notification(String id, String picUrl, long userId, String message, long associationId, Status status, Type type, Category category) {
		this();
		setId(id);
		setPicUrl(picUrl);
		setUserId(userId);
		setMessage(message);
		setStatus(status);
		setType(type);
		setCategory(category);		
		setAssociationId(associationId);
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

	public String getId() {
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
	
	public long getUserId() {
		return userId;
	}

	public void setId(String id) {
		if (id == null || id.length() == 0) {
			throw new IllegalArgumentException("Invalid identifier.");
		}
		this.id = id;
	}

	private void setPicUrl(String picUrl) {
		ValidationUtil.validateNonNull(picUrl, "Picture url can't be null.");
		this.picUrl = picUrl;
	}

	private void setMessage(String message) {
		ValidationUtil.validateNonNull(message, "Message can't be null.");
		this.message = message;
	}

	public void setStatus(Status status) {
		ValidationUtil.validateNonNull(status, "Status can't be null.");
		this.status = status;
	}

	public void setDateAdded(Date dateAdded) {
		ValidationUtil.validateNonNull(dateAdded, "Date added can't be null.");
		this.dateAdded = dateAdded;
	}

	public void setDateModified(Date dateModified) {
		ValidationUtil.validateNonNull(dateModified, "Date modified can't be null.");
		this.dateModified = dateModified;
	}

	private void setType(Type type) {
		ValidationUtil.validateNonNull(type, "Notification type can't be null.");
		this.type = type;
	}

	private void setCategory(Category category) {
		ValidationUtil.validateNonNull(category, "Notification category can't be null.");
		this.category = category;
	}
	
	private void setUserId(long userId) {		
		this.userId = userId;
	}

	public long getAssociationId() {
		return associationId;
	}

	private void setAssociationId(long associationId) {
		this.associationId = associationId;
	}
	
	String getSearchKey() {
		return getSearchKey(String.valueOf(getUserId()), String.valueOf(getAssociationId()), getCategory(), getType());
	}
	
	static String getSearchKey(String userId, String assocId, Category category, Type type) {
		return userId + assocId + category.getValue() + type.getValue();
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
