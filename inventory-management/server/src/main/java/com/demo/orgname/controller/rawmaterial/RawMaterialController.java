package com.demo.orgname.controller.rawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.rawmaterial.RawMaterial;

@RestController
@RequestMapping("/rawMaterial")
public class RawMaterialController {
	
	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(method= RequestMethod.GET)
    public String startWork() {
		System.out.println("..........................................get context: " + context);
        return "hello";
    }
	
	@RequestMapping(method= RequestMethod.POST)
    public String defaultEndpoint(@PathVariable RawMaterial rawMaterial) {
		System.out.println(".......................................post...Default ");
        return "RawMaterial saved";
    }
	
	
}
