package com.demo.orgname.controller.storage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.storage.Godown;
import com.demo.orgname.service.storage.GodownServiceImpl;

@RestController
@RequestMapping("/godown")
public class GodownController {
	
	@Autowired
	private GodownServiceImpl godownService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody Godown godown) {
		godownService.addGodown(godown);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Godown> getAll() {
		return godownService.getAllGodowns();
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Godown getById(@PathVariable String id) {
		return godownService.getGodown(id);
    }

}
