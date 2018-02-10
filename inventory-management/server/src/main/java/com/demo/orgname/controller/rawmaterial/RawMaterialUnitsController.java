package com.demo.orgname.controller.rawmaterial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.rawmaterial.RawMaterialUnit;
import com.demo.orgname.service.rawmaterial.RawMaterialUnitsServiceImpl;

@RestController
@RequestMapping("/rawMaterialUnits")
public class RawMaterialUnitsController {
	
	@Autowired
	private RawMaterialUnitsServiceImpl rawMaterialUnitsServiceImpl;

	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RawMaterialUnit> getAll() {
		return rawMaterialUnitsServiceImpl.getAllRawMaterialUnits();
    }
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterialUnit rawMaterialUnit) {
		rawMaterialUnitsServiceImpl.addRawMaterialUnit(rawMaterialUnit);
    }
}
