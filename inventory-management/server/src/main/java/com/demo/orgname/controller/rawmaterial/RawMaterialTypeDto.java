package com.demo.orgname.controller.rawmaterial;

import com.demo.orgname.dao.rawmaterial.RawMaterialType;

public class RawMaterialTypeDto {

	private String id;
	private String type;
	
	public RawMaterialTypeDto() {
		super();
	}

	public RawMaterialTypeDto(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public RawMaterialTypeDto(RawMaterialType rawMaterialType) {
		super();
		this.id = rawMaterialType.getId();
		this.type = rawMaterialType.getType();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
