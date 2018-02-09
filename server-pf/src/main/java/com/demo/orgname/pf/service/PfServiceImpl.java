package com.demo.orgname.pf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.pf.dao.contractor.ContractorLabourWage;
import com.demo.orgname.pf.dao.contractor.ContractorLabourWageRepository;

@Service
public class PfServiceImpl {
	
	@Autowired
	private ContractorLabourWageRepository contractorLabourWageRepository;

	public List<ContractorLabourWage> getAllContractorLaborWages() {
		List<ContractorLabourWage> contractorLabourWages = new ArrayList<>();
		contractorLabourWageRepository.findAll()
			.forEach(contractorLabourWages::add);
		return contractorLabourWages;
	}

}
