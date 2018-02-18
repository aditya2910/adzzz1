package com.demo.orgname.service.checker;

import com.demo.orgname.controller.checker.CheckerDto;
import com.demo.orgname.dao.checker.Checker;

public class CheckerBo extends Checker {
	
	public CheckerBo(CheckerDto dto) {
		this.setId(dto.getId());
		this.setName(dto.getName());
		this.setAddress(dto.getAddress());
		this.setPhone(dto.getPhone());
	}

}
