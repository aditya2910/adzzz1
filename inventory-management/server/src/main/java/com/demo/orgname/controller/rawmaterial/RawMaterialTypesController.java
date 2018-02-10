package com.demo.orgname.controller.rawmaterial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.rawmaterial.RawMaterialType;
import com.demo.orgname.service.rawmaterial.RawMaterialTypesServiceImpl;

@RestController
@RequestMapping("/rawMaterialTypes")
public class RawMaterialTypesController {
	
	@Autowired
	private RawMaterialTypesServiceImpl rawMaterialTypesServiceImpl;
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RawMaterialType> getAll() {
		return rawMaterialTypesServiceImpl.getAllRawMaterialTypes();
    }
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterialType rawMaterialType) {
		rawMaterialTypesServiceImpl.addRawMaterialType(rawMaterialType);
    }

}
