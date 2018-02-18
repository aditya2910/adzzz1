package com.demo.orgname.service.contractor;

import com.demo.orgname.controller.contractor.ContractorDto;
import com.demo.orgname.dao.contractor.Contractor;

public class ContractorBo extends Contractor{
	
	public ContractorBo(ContractorDto dto) {
		this.setId(dto.getId());
		this.setName(dto.getName());
		this.setAddress(dto.getAddress());
		this.setPhone(dto.getPhone());
	}

}
