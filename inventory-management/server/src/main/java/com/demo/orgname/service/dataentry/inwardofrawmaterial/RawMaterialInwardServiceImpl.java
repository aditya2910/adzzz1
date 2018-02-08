package com.demo.orgname.service.dataentry.inwardofrawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.inwardofrawmaterial.RawMaterialInward;
import com.demo.orgname.dao.dataentry.inwardofrawmaterial.RawMaterialInwardRepository;

@Service
public class RawMaterialInwardServiceImpl {
	
	@Autowired
	private RawMaterialInwardRepository repository;

	public void addRawMaterialInward(RawMaterialInward rawMaterialInward) {
		repository.save(rawMaterialInward);
	}

}
