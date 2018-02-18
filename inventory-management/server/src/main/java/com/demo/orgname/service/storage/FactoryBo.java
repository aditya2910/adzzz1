package com.demo.orgname.service.storage;

import com.demo.orgname.controller.storage.FactoryDto;
import com.demo.orgname.dao.storage.Factory;

public class FactoryBo extends Factory{

	public FactoryBo(FactoryDto dto) {
		this.setId(dto.getId());
		this.setName(dto.getName());
		this.setType(dto.getType());
		this.setArea(dto.getArea());
		this.setAddress(dto.getAddress());
		this.setPhone(dto.getAddress());
	}
}
