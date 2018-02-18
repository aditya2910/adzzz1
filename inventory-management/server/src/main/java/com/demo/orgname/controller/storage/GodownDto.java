package com.demo.orgname.controller.storage;

import com.demo.orgname.dao.storage.Godown;

public class GodownDto {
	
	private String id;
	private String name;
	private String type;
	private String area;
	private String address;
	private String phone;
	
	public GodownDto() {
		super();
	}
	
	public GodownDto(Godown godown) {
		super();
		this.id = godown.getId();
		this.name = godown.getName();
		this.type = godown.getType();
		this.area = godown.getArea();
		this.address = godown.getAddress();
		this.phone = godown.getPhone();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
