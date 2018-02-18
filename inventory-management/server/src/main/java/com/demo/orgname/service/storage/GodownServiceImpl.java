package com.demo.orgname.service.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.storage.Godown;
import com.demo.orgname.dao.storage.GodownRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;

@Service
public class GodownServiceImpl {
	
	@Autowired
	private GodownRepository repository;

	public Godown addGodown(GodownBo godownBo) throws InventoryException {
		try {
			return repository.save(new Godown(godownBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving godown", e, 500);
		}
	}

	public List<Godown> getAllGodowns() throws InventoryException {
		List<Godown> godowns = new ArrayList<>();
		
		try {
			repository.findAll()
				.forEach(godowns::add);
			return godowns;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all godowns", e, 500);
		}
	}

	public Godown getGodown(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given godown id is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting godown with id: " + id, e, 500) ;
		}
	}

	public Godown updateGodown(GodownBo godownBo) throws InventoryException {
		try {
			return repository.save(new Godown(godownBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing godown", e, 500) ;
		}
	}

	public void deleteGodown(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given godown id is invalid: " + id, 400) ;
		}
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting godown", e, 500) ;
		}
	}

}
