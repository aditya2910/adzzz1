package com.demo.orgname.service.dataentry.contractorslipentry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.contractorslipentry.ContractorSlipEntry;
import com.demo.orgname.dao.dataentry.contractorslipentry.ContractorSlipEntryRepository;

@Service
public class ContractorSlipEntryServiceImpl {
	
	@Autowired
	private ContractorSlipEntryRepository repository;

	public void addContractorSlipEntry(ContractorSlipEntry contractorSlipEntry) {
		repository.save(contractorSlipEntry);
	}

}
