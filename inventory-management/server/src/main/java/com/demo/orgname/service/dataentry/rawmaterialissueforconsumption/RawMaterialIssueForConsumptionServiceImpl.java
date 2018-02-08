package com.demo.orgname.service.dataentry.rawmaterialissueforconsumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.rawmaterialissueforconsumption.RawMaterialIssueForConsumption;
import com.demo.orgname.dao.dataentry.rawmaterialissueforconsumption.RawMaterialIssueForConsumptiondRepository;

@Service
public class RawMaterialIssueForConsumptionServiceImpl {
	
	@Autowired
	private RawMaterialIssueForConsumptiondRepository repository;

	public void addRawMaterialIssueForConsumption(RawMaterialIssueForConsumption rawMaterialIssueForConsumption) {
		repository.save(rawMaterialIssueForConsumption);
	}

}
