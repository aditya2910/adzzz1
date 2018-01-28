package com.demo.orgname.controller.rawmaterial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.rawmaterial.RawMaterial;
import com.demo.orgname.service.rawmaterial.RawMaterialServiceImpl;

@RestController
@RequestMapping("/rawMaterial")
public class RawMaterialController {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private RawMaterialServiceImpl rawMaterialService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody RawMaterial rawMaterial) {
		System.out.println("Saving Raw Material ");
		rawMaterialService.addRawMaterial(rawMaterial);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RawMaterial> getAll() {
		System.out.println("..........................................getting all raw materials: " + context);
		List<RawMaterial> rawMaterials = rawMaterialService.getAllRawMaterials();
        return rawMaterials;
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RawMaterial getById(@PathVariable String id) {
		System.out.println("getting raw material");
		RawMaterial rawMaterial = rawMaterialService.getRawMaterial(id);
		System.out.println("rawMaterial: " + rawMaterial);
        return rawMaterial;
    }
	
	@RequestMapping(value="/count", method= RequestMethod.GET)
    public int update() {
		System.out.println("getting raw materials count");
		return rawMaterialService.getRawMaterialsCount();
    }
	
	@RequestMapping(method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void getCount(@RequestBody RawMaterial rawMaterial) {
		System.out.println("updating raw material");
		rawMaterialService.updateRawMaterial(rawMaterial);
    }
	
	
	
	// custom query - NOT WORKING
}
