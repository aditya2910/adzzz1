package com.demo.orgname.controller.dataentry.rawmaterialwarehousetransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.dataentry.rawmaterialwarehousetransfer.RawMaterialWarehouseTransfer;
import com.demo.orgname.service.dataentry.rawmaterialwarehousetransfer.RawMaterialWarehouseTransferServiceImpl;

@RestController
@RequestMapping("/rawMaterialWarehouseTransferDataEntry")
public class RawMaterialWarehouseTransferController {
	
	@Autowired
	private RawMaterialWarehouseTransferServiceImpl rawMaterialWarehouseTransferDataEntryMasterService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterialWarehouseTransfer rawMaterialWarehouseTransfer) {
		rawMaterialWarehouseTransferDataEntryMasterService.addRawMaterialWarehouseTransfer(rawMaterialWarehouseTransfer);
    }

}
