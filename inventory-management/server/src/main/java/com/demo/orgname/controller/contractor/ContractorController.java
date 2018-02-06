package com.demo.orgname.controller.contractor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.contractor.Contractor;
import com.demo.orgname.service.contractor.ContractorServiceImpl;

@RestController
@RequestMapping("/contractor")
public class ContractorController {
	
	@Autowired
	private ContractorServiceImpl contractorService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody Contractor contractor) {
		contractorService.saveContractor(contractor);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Contractor> getAll() {
		List<Contractor> contractors = contractorService.getAllContractors();
        return contractors;
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Contractor getById(@PathVariable String id) {
		return contractorService.getContractor(id);
    }
	
	@RequestMapping(value="/count", method= RequestMethod.GET)
    public int getCount() {
		return contractorService.getContractorsCount();
    }
	
	@RequestMapping(method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody Contractor contractor) {
		contractorService.updateContractor(contractor);
    }

}
