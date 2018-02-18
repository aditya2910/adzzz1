package com.demo.orgname.service.checker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.checker.Checker;
import com.demo.orgname.dao.checker.CheckerRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;

@Service
public class CheckerServiceImpl {
	
	@Autowired
	private CheckerRepository repository;
	
	public Checker saveChecker(CheckerBo checkerBo) throws InventoryException {
		try {
			return repository.save(new Checker(checkerBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving checker", e, 500);
		}
	}

	public List<Checker> getAllCheckers() throws InventoryException {
		List<Checker> checkers = new ArrayList<>();
		try {
			repository.findAll()
				.forEach(checkers::add);
			return checkers;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all checkers", e, 500);
		}
	}

	public Checker getChecker(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given checker id is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting checker with id: " + id, e, 500) ;
		}
	}

	public Checker updateChecker(CheckerBo checkerBo) throws InventoryException {
		try {
			return repository.save(new Checker(checkerBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing checker", e, 500) ;
		}
	}

	public void deleteChecker(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given checker id is invalid: " + id, 400) ;
		}
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting checker", e, 500) ;
		}
	}

}
