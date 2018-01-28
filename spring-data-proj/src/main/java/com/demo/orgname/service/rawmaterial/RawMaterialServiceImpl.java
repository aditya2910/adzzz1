package com.demo.orgname.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.rawmaterial.RawMaterial;
import com.demo.orgname.dao.rawmaterial.RawMaterialRepository;

@Service
public class RawMaterialServiceImpl {
	
	@Autowired
	private RawMaterialRepository repository;
	
	public List<RawMaterial> getAllRawMaterials() {
		List<RawMaterial> rawMaterials = new ArrayList<>();
		repository.findAll()
			.forEach(rawMaterials::add);
		return rawMaterials;
	}

	public void addRawMaterial(RawMaterial rawMaterial) {
		repository.save(rawMaterial);
	}
	
	public RawMaterial getRawMaterial(String id) {
		return repository.findOne(id);
	}

	public int getRawMaterialsCount() {
		return (int) repository.count();
	}

	public void updateRawMaterial(RawMaterial rawMaterial) {
		repository.save(rawMaterial);
	}
}
