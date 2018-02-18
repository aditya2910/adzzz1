package com.demo.orgname.service.brand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.brand.ProductBrand;
import com.demo.orgname.dao.brand.ProductBrandRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;

@Service
public class ProductBrandServiceImpl {
	
	@Autowired
	private ProductBrandRepository repository;
	
	public ProductBrand saveBrand(ProductBrandBo productBrandBo) throws InventoryException {
		try {
			return repository.save(new ProductBrand(productBrandBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving product brand", e, 500);
		}
	}

	public List<ProductBrand> getAllBrands() throws InventoryException {
		List<ProductBrand> brands = new ArrayList<>();
		try {
			repository.findAll()
					.forEach(brands::add);
			return brands;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all product brands", e, 500);
		}
	}

	public ProductBrand getBrand(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given product brand id is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting product brand with id: " + id, e, 500) ;
		}
	}

	public ProductBrand updateBrand(ProductBrandBo productBrandBo) throws InventoryException {
		try {
			return repository.save(new ProductBrand(productBrandBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing product brand", e, 500) ;
		}
	}

	public void deleteBrand(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given product brand id is invalid: " + id, 400) ;
		}
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting product brand", e, 500) ;
		}
	}

}
