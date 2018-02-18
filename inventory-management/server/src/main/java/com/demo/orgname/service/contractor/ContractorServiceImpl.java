package com.demo.orgname.service.contractor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.contractor.Contractor;
import com.demo.orgname.dao.contractor.ContractorRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;

@Service
public class ContractorServiceImpl {
	
	@Autowired
	private ContractorRepository repository;

	public Contractor saveContractor(ContractorBo contractorBo) throws InventoryException {
		try {
			return repository.save(new Contractor(contractorBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving contractor", e, 500);
		}
	}

	public List<Contractor> getAllContractors() throws InventoryException {
		List<Contractor> contractors = new ArrayList<>();
		try {
			repository.findAll()
				.forEach(contractors::add);
			return contractors;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all contractors", e, 500);
		}
	}

	public Contractor getContractor(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given contractor id is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting contractor with id: " + id, e, 500) ;
		}
	}

	public Contractor updateContractor(ContractorBo contractorBo) throws InventoryException {
		try {
			return repository.save(new Contractor(contractorBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing Contractor", e, 500) ;
		}
	}

	public void deleteContractor(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given contractor id is invalid: " + id, 400) ;
		}
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting contractor", e, 500) ;
		}
	}

}
