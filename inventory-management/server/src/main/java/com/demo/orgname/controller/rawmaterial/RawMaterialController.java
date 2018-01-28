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
@RequestMapping("/rawMaterials")
public class RawMaterialController {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private RawMaterialServiceImpl rawMaterialService;
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RawMaterial> startWork() {
		System.out.println("..........................................get context: " + context);
		List<RawMaterial> rawMaterials = rawMaterialService.getAllRawMaterials();
        return rawMaterials;
    }
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void defaultEndpoint(@RequestBody RawMaterial rawMaterial) {
		System.out.println(".......................................post...Default ");
        //return "RawMaterial saved";
    }
	
	
}
