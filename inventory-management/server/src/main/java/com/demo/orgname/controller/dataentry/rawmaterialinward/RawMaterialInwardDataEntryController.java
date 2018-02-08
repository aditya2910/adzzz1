package com.demo.orgname.controller.dataentry.rawmaterialinward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.dataentry.rawmaterialinward.RawMaterialInwardDataEntry;
import com.demo.orgname.service.dataentry.rawmaterial.RawMaterialInwardDataEntryServiceImpl;

@RestController
@RequestMapping("/rawMaterialInward")
public class RawMaterialInwardDataEntryController {
	
	@Autowired
	private RawMaterialInwardDataEntryServiceImpl rawMaterialInwardDataEntryService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterialInwardDataEntry rawMaterialInwardDataEntry) {
		rawMaterialInwardDataEntryService.addRawMaterialInwardDataEntry(rawMaterialInwardDataEntry);
    }

}
