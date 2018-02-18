package com.demo.orgname.controller.checker;

import com.demo.orgname.dao.checker.Checker;

public class CheckerDto {
	
	private String id;
	private String name;
	private String address;
	private String phone;
	
	public CheckerDto() {
		super();
	}
	
	public CheckerDto(Checker checker) {
		super();
		this.id = checker.getId();
		this.name = checker.getName();
		this.address = checker.getAddress();
		this.phone = checker.getPhone();
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
