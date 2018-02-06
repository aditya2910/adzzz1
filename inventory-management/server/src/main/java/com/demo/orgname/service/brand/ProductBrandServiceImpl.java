package com.demo.orgname.service.brand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.brand.ProductBrand;
import com.demo.orgname.dao.brand.ProductBrandRepository;

@Service
public class ProductBrandServiceImpl {
	
	@Autowired
	private ProductBrandRepository repository;
	
	public void saveBrand(ProductBrand brand) {
		repository.save(brand);
	}

	public List<ProductBrand> getAllBrands() {
		List<ProductBrand> brands = new ArrayList<>();
		repository.findAll()
			.forEach(brands::add);
		return brands;
	}

	public ProductBrand getBrand(String id) {
		return repository.findOne(id);
	}

	public int getBrandsCount() {
		return (int) repository.count();
	}

	public void updateBrand(ProductBrand brand) {
		repository.save(brand);
	}

}
