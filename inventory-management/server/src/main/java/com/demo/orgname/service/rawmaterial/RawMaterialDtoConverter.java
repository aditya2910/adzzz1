package com.demo.orgname.service.rawmaterial;

import com.demo.orgname.dao.rawmaterial.RawMaterial;

public class RawMaterialDtoConverter {
	
	public static RawMaterialDto convert(RawMaterial rawMaterial) {
		return new RawMaterialDto(rawMaterial.getId(), rawMaterial.getName(), rawMaterial.getUnit(), rawMaterial.getType());	
	}

}
