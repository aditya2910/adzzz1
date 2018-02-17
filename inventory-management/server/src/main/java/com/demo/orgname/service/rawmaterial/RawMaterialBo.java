package com.demo.orgname.service.rawmaterial;

import com.demo.orgname.controller.rawmaterial.RawMaterialDto;
import com.demo.orgname.dao.rawmaterial.RawMaterial;

public class RawMaterialBo extends RawMaterial {

	public RawMaterialBo(RawMaterialDto dto) {
		this.setName(dto.getName());
		this.setUnit(dto.getUnit());
		this.setType(dto.getUnit());
	}
	
	@Override
	public void setName(String name) {
		if(name == null || name.isEmpty() || name.length() <= 1) {
			throw new IllegalArgumentException("Input name is invalid");
		}
		super.setName(name);
	}
	
	@Override
	public void setUnit(String unit) {
		if(unit == null || unit.isEmpty() || unit.length() <= 1) {
			throw new IllegalArgumentException("Input unit is invalid");
		}
		super.setUnit(unit);
	}
}
