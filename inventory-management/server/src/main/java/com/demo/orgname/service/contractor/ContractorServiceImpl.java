package com.demo.orgname.service.contractor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.contractor.Contractor;
import com.demo.orgname.dao.contractor.ContractorRepository;

@Service
public class ContractorServiceImpl {
	
	@Autowired
	private ContractorRepository repository;

	public void saveContractor(Contractor contractor) {
		repository.save(contractor);
	}

	public List<Contractor> getAllContractors() {
		List<Contractor> contractors = new ArrayList<>();
		repository.findAll()
			.forEach(contractors::add);
		return contractors;
	}

	public Contractor getContractor(String id) {
		return repository.findOne(id);
	}

	public int getContractorsCount() {
		return (int) repository.count();
	}

	public void updateContractor(Contractor contractor) {
		repository.save(contractor);
	}

}
