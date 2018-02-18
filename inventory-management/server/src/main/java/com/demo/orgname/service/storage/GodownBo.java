package com.demo.orgname.service.storage;

import com.demo.orgname.controller.storage.GodownDto;
import com.demo.orgname.dao.storage.Godown;

public class GodownBo extends Godown{
	
	public GodownBo(GodownDto dto) {
		this.setId(dto.getId());
		this.setName(dto.getName());
		this.setType(dto.getType());
		this.setArea(dto.getArea());
		this.setAddress(dto.getAddress());
		this.setPhone(dto.getAddress());
	}

}
