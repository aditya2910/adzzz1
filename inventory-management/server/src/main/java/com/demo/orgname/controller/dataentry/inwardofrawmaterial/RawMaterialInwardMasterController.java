package com.demo.orgname.controller.dataentry.inwardofrawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.dataentry.rawmaterialinward.RawMaterialInwardDataEntryMaster;
import com.demo.orgname.service.dataentry.rawmaterial.RawMaterialInwardDataEntryMasterServiceImpl;


@RestController
@RequestMapping("/rawMaterialInwardMaster")
public class RawMaterialInwardMasterController {
	
	@Autowired
	private RawMaterialInwardDataEntryMasterServiceImpl rawMaterialInwardDataEntryMasterService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterialInwardDataEntryMaster rawMaterialInwardDataEntryMaster) {
		rawMaterialInwardDataEntryMasterService.addRawMaterialInwardDataEntry(rawMaterialInwardDataEntryMaster);
    }

}
