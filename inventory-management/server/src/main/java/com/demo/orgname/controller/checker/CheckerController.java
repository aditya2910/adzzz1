package com.demo.orgname.controller.checker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.checker.Checker;
import com.demo.orgname.service.checker.CheckerServiceImpl;

@RestController
@RequestMapping("/checker")
public class CheckerController {
	
	@Autowired
	private CheckerServiceImpl checkerService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody Checker checker) {
		checkerService.saveChecker(checker);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Checker> getAll() {
		return checkerService.getAllCheckers();
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Checker getById(@PathVariable String id) {
		return checkerService.getChecker(id);
    }

}
