package com.demo.orgname.pf.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.pf.dao.contractor.ContractorLabourWage;
import com.demo.orgname.pf.dao.contractor.ContractorLabourWageRepository;
import com.demo.orgname.pf.dao.person.MasterPfPerson;
import com.demo.orgname.pf.dao.person.MasterPfPersonRepository;
import com.demo.orgname.pf.dao.report.wagespf.MasterPfPersonWagesPf;
import com.demo.orgname.pf.dao.report.wagespf.MasterPfPersonWagesPfRepository;

@Service
public class PfServiceImpl {
	
	@Autowired
	private ContractorLabourWageRepository contractorLabourWageRepository;
	
	@Autowired
	private MasterPfPersonRepository masterPfPersonRepository;
	
	@Autowired
	private MasterPfPersonWagesPfRepository masterPfPersonWagesPfRepository;

	public void saveConsolidatedPersonWithWageAndPfDistribution() {
		Map<String, String> contractorCodeAndWage = getContractorCodeAndWage();
		
		List<MasterPfPerson> persons = (List<MasterPfPerson>) masterPfPersonRepository.findAll();
		for (MasterPfPerson person : persons) {
			MasterPfPersonWagesPf personWagesPf = new MasterPfPersonWagesPf();
			personWagesPf.setName(person.getName());
			personWagesPf.setReportGenDate(new Date().toString());
			personWagesPf.setUanNo(person.getUanNo());
			personWagesPf.setAddress(person.getAddress());
			//personWagesPf.setContractorCode(person.getContractorCode());
			//personWagesPf.setWage(contractorCodeAndWage.get(person.getContractorCode()));
			masterPfPersonWagesPfRepository.save(personWagesPf);
		}
	}

	private Map<String, String> getContractorCodeAndWage() {
		Map<String, String> contractorCodeAndWage = new HashMap<>();
		List<ContractorLabourWage> contractorLabourWages= (List<ContractorLabourWage>) contractorLabourWageRepository.findAll();
		for (ContractorLabourWage contractorLabourWage : contractorLabourWages) {
			contractorCodeAndWage.put(contractorLabourWage.getContractorCode(), contractorLabourWage.getContractorLaboursWage());
		}
		return contractorCodeAndWage;
	}

	public void createECRReport(String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true));
			bw.write("hello");
			bw.newLine();
			bw.write("world");
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
