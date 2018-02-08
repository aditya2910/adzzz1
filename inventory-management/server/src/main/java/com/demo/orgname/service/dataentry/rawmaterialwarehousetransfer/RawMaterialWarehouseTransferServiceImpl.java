package com.demo.orgname.service.dataentry.rawmaterialwarehousetransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.rawmaterialwarehousetransfer.RawMaterialWarehouseTransfer;
import com.demo.orgname.dao.dataentry.rawmaterialwarehousetransfer.RawMaterialWarehouseTransferRepository;

@Service
public class RawMaterialWarehouseTransferServiceImpl {
	
	@Autowired
	private RawMaterialWarehouseTransferRepository repository;

	public void addRawMaterialWarehouseTransfer(RawMaterialWarehouseTransfer rawMaterialWarehouseTransfer) {
		repository.save(rawMaterialWarehouseTransfer);
	}

}
