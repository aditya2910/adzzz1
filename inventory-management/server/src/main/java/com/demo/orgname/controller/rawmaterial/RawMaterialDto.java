package com.demo.orgname.controller.rawmaterial;

import com.demo.orgname.dao.rawmaterial.RawMaterial;

public class RawMaterialDto {
	
	private String id;
	private String name;
	private String unit;
    private String type;
    
    public RawMaterialDto() {
    }
    
    public RawMaterialDto(RawMaterial rawMaterial) {
    		super();
		this.id = rawMaterial.getId();
		this.name = rawMaterial.getName();
		this.unit = rawMaterial.getUnit();
		this.type = rawMaterial.getUnit();
    }
    
	public RawMaterialDto(String id, String name, String unit, String type) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.type = type;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public String getType() {
		return type;
	}
    
    

}
