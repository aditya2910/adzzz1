package com.demo.orgname.controller.brand;

import com.demo.orgname.dao.brand.ProductBrand;

public class ProductBrandDto {
	
	private String id;
	private String name;
	private String type;
	
	public ProductBrandDto() {
		super();
	}
	
	public ProductBrandDto(ProductBrand productBrand) {
		super();
		this.id = productBrand.getId();
		this.name = productBrand.getName();
		this.type = productBrand.getType();
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

}
