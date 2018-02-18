package com.demo.orgname.service.brand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.brand.ProductType;
import com.demo.orgname.dao.brand.ProductTypeRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;

@Service
public class ProductTypeServiceImpl {
	
	@Autowired
	private ProductTypeRepository repository;
	
	public ProductType saveType(ProductTypeBo productTypeBo) throws InventoryException {
		try {
			return repository.save(new ProductType(productTypeBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving product type", e, 500);
		}
	}

	public List<ProductType> getAllTypes() throws InventoryException {
		List<ProductType> types = new ArrayList<>();
		try {
			repository.findAll()
				.forEach(types::add);
			return types;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all product types", e, 500);
		}
	}

	public ProductType getType(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given product type id is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting product type with id: " + id, e, 500) ;
		}
	}

	public ProductType updateType(ProductTypeBo productTypeBo) throws InventoryException {
		try {
			return repository.save(new ProductType(productTypeBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing product type", e, 500) ;
		}
	}

	public void deleteType(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given product type id is invalid: " + id, 400) ;
		}
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting product type", e, 500) ;
		}
	}

}
