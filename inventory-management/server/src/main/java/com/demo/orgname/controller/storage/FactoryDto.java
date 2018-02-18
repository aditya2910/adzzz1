package com.demo.orgname.controller.storage;

import com.demo.orgname.dao.storage.Factory;

public class FactoryDto {
	
	private String id;
	private String name;
	private String type;
	private String area;
	private String address;
	private String phone;
	
	public FactoryDto() {
		super();
	}
	
	public FactoryDto(Factory factory) {
		super();
		this.id = factory.getId();
		this.name = factory.getName();
		this.type = factory.getType();
		this.area = factory.getArea();
		this.address = factory.getAddress();
		this.phone = factory.getPhone();
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
