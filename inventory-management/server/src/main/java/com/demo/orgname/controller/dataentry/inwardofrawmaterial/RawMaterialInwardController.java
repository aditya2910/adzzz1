package com.demo.orgname.controller.dataentry.inwardofrawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.dataentry.inwardofrawmaterial.RawMaterialInwardMetaData;
import com.demo.orgname.service.dataentry.inwardofrawmaterial.RawMaterialInwardServiceImpl;


@RestController
@RequestMapping("/rawMaterialInwardDataEntry")
public class RawMaterialInwardController {
	
	@Autowired
	private RawMaterialInwardServiceImpl rawMaterialInwardDataEntryMasterService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterialInwardMetaData rawMaterialInwardDataEntryMaster) {
		rawMaterialInwardDataEntryMasterService.addRawMaterialInwardDataEntry(rawMaterialInwardDataEntryMaster);
    }

}
