package com.demo.orgname.service.brand;

import com.demo.orgname.controller.brand.ProductTypeDto;
import com.demo.orgname.dao.brand.ProductType;

public class ProductTypeBo extends ProductType{
	
	public ProductTypeBo(ProductTypeDto productTypeDto) {
		this.setId(productTypeDto.getId());
		this.setName(productTypeDto.getName());
	}

}
