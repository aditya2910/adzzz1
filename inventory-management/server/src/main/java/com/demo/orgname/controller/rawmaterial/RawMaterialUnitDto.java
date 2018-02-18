package com.demo.orgname.controller.rawmaterial;

import com.demo.orgname.dao.rawmaterial.RawMaterialUnit;

public class RawMaterialUnitDto {
	
	private String id;
	private String unit;
	private String code;
	private String conversionRate;
	
	public RawMaterialUnitDto() {
		super();
	}

	public RawMaterialUnitDto(String id, String unit, String code, String conversionRate) {
		super();
		this.id = id;
		this.unit = unit;
		this.code = code;
		this.conversionRate = conversionRate;
	}
	
	public RawMaterialUnitDto(RawMaterialUnit rawMaterialUnit) {
		super();
		this.id = rawMaterialUnit.getId();
		this.unit = rawMaterialUnit.getUnit();
		this.code = rawMaterialUnit.getCode();
		this.conversionRate = rawMaterialUnit.getConversionRate();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}
}
