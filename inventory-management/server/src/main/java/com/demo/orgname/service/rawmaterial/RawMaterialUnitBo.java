package com.demo.orgname.service.rawmaterial;

import com.demo.orgname.controller.rawmaterial.RawMaterialUnitDto;
import com.demo.orgname.dao.rawmaterial.RawMaterialUnit;

public class RawMaterialUnitBo extends RawMaterialUnit{
	
	public RawMaterialUnitBo(RawMaterialUnitDto rawMaterialUnitDto) {
		this.setId(rawMaterialUnitDto.getId());
		this.setUnit(rawMaterialUnitDto.getUnit());
		this.setCode(rawMaterialUnitDto.getCode());
		this.setConversionRate(rawMaterialUnitDto.getConversionRate());
	}

}
