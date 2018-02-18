package com.demo.orgname.controller.contractor;

import com.demo.orgname.dao.contractor.Contractor;

public class ContractorDto {
	
	private String id;
	private String name;
	private String address;
	private String phone;
	
	public ContractorDto() {
		super();
	}
	
	public ContractorDto(Contractor contractor) {
		super();
		this.id = contractor.getId();
		this.name = contractor.getName();
		this.address = contractor.getAddress();
		this.phone = contractor.getPhone();
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
