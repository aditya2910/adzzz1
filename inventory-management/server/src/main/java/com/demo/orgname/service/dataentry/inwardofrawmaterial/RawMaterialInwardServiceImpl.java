package com.demo.orgname.service.dataentry.inwardofrawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.inwardofrawmaterial.RawMaterialInwardMetaData;
import com.demo.orgname.dao.dataentry.inwardofrawmaterial.RawMaterialInwardMetaDataRepository;

@Service
public class RawMaterialInwardServiceImpl {
	
	@Autowired
	private RawMaterialInwardMetaDataRepository repository;

	public void addRawMaterialInwardDataEntry(RawMaterialInwardMetaData rawMaterialInwardDataEntry) {
		repository.save(rawMaterialInwardDataEntry);
	}

}
