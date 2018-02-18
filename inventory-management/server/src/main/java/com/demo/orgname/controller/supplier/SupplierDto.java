package com.demo.orgname.controller.supplier;

import com.demo.orgname.dao.supplier.Supplier;

public class SupplierDto {
	
	private String id;
	private String name;
	private String type;
	private String address;
	private String phone;
	
	public SupplierDto() {
		super();
	}
	
	public SupplierDto(Supplier supplier) {
		super();
		this.id = supplier.getId();
		this.name = supplier.getName();
		this.type = supplier.getType();
		this.address = supplier.getAddress();
		this.phone = supplier.getPhone();
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
