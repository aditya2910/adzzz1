package com.demo.orgname.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.rawmaterial.RawMaterialUnit;
import com.demo.orgname.dao.rawmaterial.RawMaterialUnitsRepository;

@Service
public class RawMaterialUnitsServiceImpl {
	
	@Autowired
	private RawMaterialUnitsRepository rawMaterialUnitsRepository;

	public List<RawMaterialUnit> getAllRawMaterialUnits() {
		List<RawMaterialUnit> rawMaterialUnits = new ArrayList<>();
		rawMaterialUnitsRepository.findAll()
				.forEach(rawMaterialUnits::add);
		return rawMaterialUnits;
	}

}
