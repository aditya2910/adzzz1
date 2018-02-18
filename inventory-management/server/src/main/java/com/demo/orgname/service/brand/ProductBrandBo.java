package com.demo.orgname.service.brand;

import com.demo.orgname.controller.brand.ProductBrandDto;
import com.demo.orgname.dao.brand.ProductBrand;

public class ProductBrandBo extends ProductBrand{
	
	public ProductBrandBo(ProductBrandDto dto) {
		this.setId(dto.getId());
		this.setName(dto.getName());
		this.setType(dto.getType());
	}

}
