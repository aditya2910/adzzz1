package com.demo.orgname.service.rawmaterial;

public class RawMaterialDto {
	
	private String id;
	private String name;
	private String unit;
    private String type;
    
	public RawMaterialDto(String id, String name, String unit, String type) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.type = type;
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
