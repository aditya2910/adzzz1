package com.demo.orgname.pf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.pf.dao.MasterPfPerson;
import com.demo.orgname.pf.dao.MasterPfPersonRepository;

@Service
public class ReadExcel {
	
	@Autowired
	private MasterPfPersonRepository repository;
	
	public List<MasterPfPerson> getAllMasterPfPersons(){
		List<MasterPfPerson> persons = new ArrayList<>();
		
		MasterPfPerson person = new MasterPfPerson("1234567890123456", "Nandan", "Pakur", "M005");
		
		persons.add(person);
		
		return persons;
	}
	
	public boolean savePfPerson(MasterPfPerson person) {
		repository.save(person);
		return true;
	}
}
