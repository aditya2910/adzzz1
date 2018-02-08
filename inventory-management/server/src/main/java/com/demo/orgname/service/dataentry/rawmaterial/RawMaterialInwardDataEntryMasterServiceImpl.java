package com.demo.orgname.service.dataentry.rawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.rawmaterialinward.RawMaterialInwardDataEntryMaster;
import com.demo.orgname.dao.dataentry.rawmaterialinward.RawMaterialInwardDataEntryMasterRepository;

@Service
public class RawMaterialInwardDataEntryMasterServiceImpl {
	
	@Autowired
	private RawMaterialInwardDataEntryMasterRepository repository;

	public void addRawMaterialInwardDataEntry(RawMaterialInwardDataEntryMaster rawMaterialInwardDataEntry) {
		repository.save(rawMaterialInwardDataEntry);
	}

}
