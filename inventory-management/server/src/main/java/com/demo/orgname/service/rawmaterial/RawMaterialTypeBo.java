package com.demo.orgname.service.rawmaterial;

import com.demo.orgname.controller.rawmaterial.RawMaterialTypeDto;
import com.demo.orgname.dao.rawmaterial.RawMaterialType;

public class RawMaterialTypeBo extends RawMaterialType {
	
	public RawMaterialTypeBo(RawMaterialTypeDto rawMaterialTypeDto) {
		this.setId(rawMaterialTypeDto.getId());
		this.setType(rawMaterialTypeDto.getType());
	}
}
