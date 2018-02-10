package com.demo.orgname.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.rawmaterial.RawMaterialType;
import com.demo.orgname.dao.rawmaterial.RawMaterialTypesRepository;

@Service
public class RawMaterialTypesServiceImpl {
	
	@Autowired
	private RawMaterialTypesRepository rawMaterialTypesRepository;

	public List<RawMaterialType> getAllRawMaterialTypes() {
		List<RawMaterialType> rawMaterialTypes = new ArrayList<>();
		rawMaterialTypesRepository.findAll()
				.forEach(rawMaterialTypes::add);
		return rawMaterialTypes;
	}

	public void addRawMaterialType(RawMaterialType rawMaterialType) {
		rawMaterialTypesRepository.save(rawMaterialType);
	}

}
