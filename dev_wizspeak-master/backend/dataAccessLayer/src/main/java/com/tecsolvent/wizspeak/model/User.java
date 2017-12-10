package com.tecsolvent.wizspeak.model;

/**
 * Created by jaison on 23/2/16.
 */
public class User {

	private long id;
	private int city,state,country;
	private boolean activated;
	private String first_name;
	private String last_name;
	private String dob;
	private String email;
	private String profileStatus;
	private String profilePic;

	public String getGetCoverPic() {
		return getCoverPic;
	}

	public void setGetCoverPic(String getCoverPic) {
		this.getCoverPic = getCoverPic;
	}

	private String getCoverPic;
	private String userId;
	private String gender;
	private String status;
	private byte mentor;


	public User() {
	}

	public long getId() {
		return id;

	}

	public User(long id,String userId, String first_name, String last_name,String dob, String email) {
		this.id = id;
		this.userId = userId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.email = email;
	}

	public User(long id, int city, int state, int country, byte mentor, String first_name, String last_name, String dob, String email, String profileStatus) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.mentor = mentor;
		this.activated = activated;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.email = email;
		this.profileStatus = profileStatus;
	}

	public User(long id, int city, int state, int country, byte mentor, String first_name, String last_name, String dob, String email, String profileStatus,String profilePic) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.mentor = mentor;
		this.activated = activated;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.email = email;
		this.profileStatus = profileStatus;
		this.profilePic = profilePic;
	}

	//setters


	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public void setMentor(byte mentor) {
		this.mentor = mentor;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public void getCoverPic(String getCoverPic) {
		this.getCoverPic = getCoverPic;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setStatus(String status) {
		this.status = status;
	}
//getter


	public String getProfilePic() {
		return profilePic;
	}

	public int getCity() {

		return city;
	}

	public String getUserId() {
		return userId;
	}

	public int getState() {
		return state;
	}

	public int getCountry() {
		return country;
	}

	public byte getMentor() {
		return mentor;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public String getGender() {
		return gender;
	}

	public String getStatus() {
		return status;
	}
}
