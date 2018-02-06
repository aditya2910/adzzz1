package com.demo.orgname.service.brand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.brand.ProductType;
import com.demo.orgname.dao.brand.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl {
	
	@Autowired
	private ProductTypeRepository repository;
	
	public void saveType(ProductType brand) {
		repository.save(brand);
	}

	public List<ProductType> getAllTypes() {
		List<ProductType> types = new ArrayList<>();
		repository.findAll()
			.forEach(types::add);
		return types;
	}

	public ProductType getType(String id) {
		return repository.findOne(id);
	}

}
