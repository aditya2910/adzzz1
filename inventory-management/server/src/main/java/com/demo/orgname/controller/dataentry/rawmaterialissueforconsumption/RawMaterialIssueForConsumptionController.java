package com.demo.orgname.controller.dataentry.rawmaterialissueforconsumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.dataentry.rawmaterialissueforconsumption.RawMaterialIssueForConsumption;
import com.demo.orgname.service.dataentry.rawmaterialissueforconsumption.RawMaterialIssueForConsumptionServiceImpl;

/**
 * all these RWs are being used for labeling of raw material
 * @author adityakumar
 *
 */
@RestController
@RequestMapping("/rawMaterialIssueForConsumptionDataEntry")
public class RawMaterialIssueForConsumptionController {
	
	@Autowired
	private RawMaterialIssueForConsumptionServiceImpl rawMaterialIssueForConsumptionServiceImpl;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterialIssueForConsumption rawMaterialIssueForConsumption) {
		rawMaterialIssueForConsumptionServiceImpl.addRawMaterialIssueForConsumption(rawMaterialIssueForConsumption);
    }

}
