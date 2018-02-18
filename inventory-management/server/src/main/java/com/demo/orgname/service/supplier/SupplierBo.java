package com.demo.orgname.service.supplier;

import com.demo.orgname.controller.supplier.SupplierDto;
import com.demo.orgname.dao.supplier.Supplier;

public class SupplierBo extends Supplier{
	
	public SupplierBo(SupplierDto dto) {
		this.setId(dto.getId());
		this.setName(dto.getName());
		this.setType(dto.getType());
		this.setAddress(dto.getAddress());
		this.setPhone(dto.getPhone());
	}
	
}
