package com.demo.orgname.service.dataentry.rawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.rawmaterialinward.RawMaterialInwardMetaData;
import com.demo.orgname.dao.dataentry.rawmaterialinward.RawMaterialInwardMetaDataRepository;

@Service
public class RawMaterialInwardServiceImpl {
	
	@Autowired
	private RawMaterialInwardMetaDataRepository repository;

	public void addRawMaterialInwardDataEntry(RawMaterialInwardMetaData rawMaterialInwardDataEntry) {
		repository.save(rawMaterialInwardDataEntry);
	}

}
