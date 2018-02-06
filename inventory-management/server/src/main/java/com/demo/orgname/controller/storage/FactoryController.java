package com.demo.orgname.controller.storage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.storage.Factory;
import com.demo.orgname.service.storage.FactoryServiceImpl;

@RestController
@RequestMapping("/factory")
public class FactoryController {
	
	@Autowired
	private FactoryServiceImpl factoryService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody Factory factory) {
		factoryService.addFactory(factory);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Factory> getAll() {
		return factoryService.getAllFactories();
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Factory getById(@PathVariable String id) {
		return factoryService.getFactory(id);
    }

}
