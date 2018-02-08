package com.demo.orgname.controller.dataentry.contractorslipentry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.dataentry.contractorslipentry.ContractorSlipEntry;
import com.demo.orgname.service.dataentry.contractorslipentry.ContractorSlipEntryServiceImpl;

/**
 * contractor production and consumption
 * @author adityakumar
 *
 */
@RestController
@RequestMapping("/contractorSlipDataEntry")
public class ContractorSlipEntryController {
	
	@Autowired
	private ContractorSlipEntryServiceImpl contractorSlipEntryServiceImpl;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody ContractorSlipEntry contractorSlipEntry) {
		contractorSlipEntryServiceImpl.addContractorSlipEntry(contractorSlipEntry);
    }

}
