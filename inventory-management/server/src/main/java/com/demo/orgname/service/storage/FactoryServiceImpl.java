package com.demo.orgname.service.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.storage.Factory;
import com.demo.orgname.dao.storage.FactoryRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;

@Service
public class FactoryServiceImpl {
	
	@Autowired
	private FactoryRepository repository;
	
	public Factory addFactory(FactoryBo factoryBo) throws InventoryException {
		try {
			return repository.save(new Factory(factoryBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving factory", e, 500);
		}
	}

	public List<Factory> getAllFactories() throws InventoryException {
		List<Factory> factories = new ArrayList<>();
		try {
			repository.findAll()
			.forEach(factories::add);
			return factories;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all factories", e, 500);
		}
	}

	public Factory getFactory(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given factory id is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting factory with id: " + id, e, 500) ;
		}
	}

	public Factory updateFactory(FactoryBo factoryBo) throws InventoryException {
		try {
			return repository.save(new Factory(factoryBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing factory", e, 500) ;
		}
	}

	public void deleteFactory(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given factory id is invalid: " + id, 400) ;
		}
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting factory", e, 500) ;
		}
	}

}
