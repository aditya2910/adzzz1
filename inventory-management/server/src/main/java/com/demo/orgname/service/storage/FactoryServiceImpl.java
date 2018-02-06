package com.demo.orgname.service.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.storage.Factory;
import com.demo.orgname.dao.storage.FactoryRepository;

@Service
public class FactoryServiceImpl {
	
	@Autowired
	private FactoryRepository repository;
	
	public void addFactory(Factory factory) {
		repository.save(factory);
	}

	public List<Factory> getAllFactories() {
		List<Factory> factories = new ArrayList<>();
		repository.findAll()
			.forEach(factories::add);
		return factories;
	}

	public Factory getFactory(String id) {
		return repository.findOne(id);
	}

}
