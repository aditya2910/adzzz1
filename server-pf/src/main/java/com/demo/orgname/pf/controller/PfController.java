package com.demo.orgname.pf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.pf.dao.MasterPfPerson;
import com.demo.orgname.pf.service.ReadExcel;

@RestController
@RequestMapping("/pf")
public class PfController {
	
	@Autowired
	private ReadExcel readExcel;
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getAll() {
		List<MasterPfPerson> persons = readExcel.getAllMasterPfPersons();
		for (MasterPfPerson person : persons) {
			readExcel.savePfPerson(person);
		}
		return "Hello World!";
    }

}
