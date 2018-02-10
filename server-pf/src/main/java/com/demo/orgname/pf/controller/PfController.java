package com.demo.orgname.pf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.pf.dao.contractor.ContractorLabourWage;
import com.demo.orgname.pf.dao.person.MasterPfPerson;
import com.demo.orgname.pf.service.PfPersonContractorServiceImpl;
import com.demo.orgname.pf.service.PfServiceImpl;

@RestController
@RequestMapping("/pf")
public class PfController {
	// NOTE: format all cells in excel to text
	
	@Autowired
	private PfPersonContractorServiceImpl pfPersonContractorService;
	
	@Autowired
	private PfServiceImpl pfService;
	
	private String MASTER_PF_FILEPATH = "/Users/adityakumar/Desktop/data/pf/pf_data_master.xlsx";
	
	private String MASTER_PF_FILEPATH_FORM_10 = "/Users/adityakumar/Desktop/data/pf_data_master_form_10.xlsx";
	
	private String PF_CONTRACTOR_LABOUR_WAGE_LIST = "/Users/adityakumar/Desktop/data/pf_contractor_labour_wage_list.xlsx";
	
	private String ECR_REPORT_FILEPATH = "/Users/adityakumar/Desktop/data/ecr.txt";
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getAll() {
		List<MasterPfPerson> persons = pfPersonContractorService.getAllMasterPfPersons(MASTER_PF_FILEPATH);
		for (MasterPfPerson person : persons) {
			pfPersonContractorService.savePfPerson(person);
		}
		
//		List<ContractorLabourWage> contractorLabourWages = pfPersonContractorService.getAllContractorLabourWages(PF_CONTRACTOR_LABOUR_WAGE_LIST);
//		for (ContractorLabourWage contractorLabourWage : contractorLabourWages) {
//			pfPersonContractorService.saveContractorLabourWages(contractorLabourWage);
//		}
//		
//		pfService.saveConsolidatedPersonWithWageAndPfDistribution();
//		
//		pfService.createECRReport(ECR_REPORT_FILEPATH);
		
		return "Hello World!";
    }

}
