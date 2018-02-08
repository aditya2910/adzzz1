package com.demo.orgname.service.checker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.checker.Checker;
import com.demo.orgname.dao.checker.CheckerRepository;

@Service
public class CheckerServiceImpl {
	
	@Autowired
	private CheckerRepository repository;
	
	public void saveChecker(Checker checker) {
		repository.save(checker);
	}

	public List<Checker> getAllCheckers() {
		List<Checker> checkers = new ArrayList<>();
		repository.findAll()
			.forEach(checkers::add);
		return checkers;
	}

	public Checker getChecker(String id) {
		return repository.findOne(id);
	}

}
