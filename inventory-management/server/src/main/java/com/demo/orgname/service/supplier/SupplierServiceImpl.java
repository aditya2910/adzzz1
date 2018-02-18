package com.demo.orgname.service.supplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.supplier.Supplier;
import com.demo.orgname.dao.supplier.SupplierRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;


@Service
public class SupplierServiceImpl {
	
	@Autowired
	private SupplierRepository repository;

	public Supplier saveSupplier(SupplierBo supplierBo) throws InventoryException {
		try {
			return repository.save(new Supplier(supplierBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving Supplier", e, 500);
		}
	}

	public List<Supplier> getAllSuppliers() throws InventoryException {
		List<Supplier> suppliers = new ArrayList<>();
		try {
			repository.findAll()
				.forEach(suppliers::add);
			return suppliers;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all suppliers", e, 500);
		}
	}

	public Supplier getSupplier(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given supplier id is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting supplier with id: " + id, e, 500) ;
		}
	}

	public Supplier updateSupplier(SupplierBo supplierBo) throws InventoryException {
		try {
			return repository.save(new Supplier(supplierBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing supplier", e, 500) ;
		}
	}

	public void deleteSupplier(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given supplier id is invalid: " + id, 400) ;
		}
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting supplier", e, 500) ;
		}
	}

}
