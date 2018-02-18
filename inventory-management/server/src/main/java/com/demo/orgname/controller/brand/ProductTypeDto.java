package com.demo.orgname.controller.brand;

import com.demo.orgname.dao.brand.ProductType;

public class ProductTypeDto {
	
	private String id;
	private String name;
	
	public ProductTypeDto() {
		super();
	}
	
	public ProductTypeDto(ProductType productType) {
		super();
		this.id = productType.getId();
		this.name = productType.getName();
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

	
}
