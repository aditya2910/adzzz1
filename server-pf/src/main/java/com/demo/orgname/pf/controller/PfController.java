package com.demo.orgname.pf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.pf.dao.contractor.ContractorLabourWage;
import com.demo.orgname.pf.dao.person.MasterPfPerson;
import com.demo.orgname.pf.service.PfServiceImpl;
import com.demo.orgname.pf.service.ReadExcel;

@RestController
@RequestMapping("/pf")
public class PfController {
	// NOTE: format all cells in excel to text
	
	@Autowired
	private ReadExcel readExcel;
	
	@Autowired
	private PfServiceImpl pfService;
	
	private String MASTER_PF_FILEPATH = "/Users/adityakumar/Desktop/data/pf_data_master.xlsx";
	
	private String PF_CONTRACTOR_LABOUR_WAGE_LIST = "/Users/adityakumar/Desktop/data/pf_contractor_labour_wage_list.xlsx";
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getAll() {
		List<MasterPfPerson> persons = readExcel.getAllMasterPfPersons(MASTER_PF_FILEPATH);
		for (MasterPfPerson person : persons) {
			readExcel.savePfPerson(person);
		}
		
		List<ContractorLabourWage> contractorLabourWages = readExcel.getAllContractorLabourWages(PF_CONTRACTOR_LABOUR_WAGE_LIST);
		for (ContractorLabourWage contractorLabourWage : contractorLabourWages) {
			readExcel.saveContractorLabourWages(contractorLabourWage);
		}
		
		List<ContractorLabourWage> contractorLabourWagesForReport = pfService.getAllContractorLaborWages();
		System.out.println("size: " + contractorLabourWagesForReport);
		return "Hello World!";
    }

}
