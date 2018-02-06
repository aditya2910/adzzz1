package com.demo.orgname.service.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.storage.Godown;
import com.demo.orgname.dao.storage.GodownRepository;

@Service
public class GodownServiceImpl {
	
	@Autowired
	private GodownRepository repository;

	public void addGodown(Godown godown) {
		repository.save(godown);
	}

	public List<Godown> getAllGodowns() {
		List<Godown> godowns = new ArrayList<>();
		repository.findAll()
			.forEach(godowns::add);
		return godowns;
	}

	public Godown getGodown(String id) {
		return repository.findOne(id);
	}

}
