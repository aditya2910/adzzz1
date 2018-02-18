package com.demo.orgname.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.rawmaterial.RawMaterialUnit;
import com.demo.orgname.dao.rawmaterial.RawMaterialUnitRepository;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.util.StringUtility;

@Service
public class RawMaterialUnitServiceImpl {
	
	@Autowired
	private RawMaterialUnitRepository rawMaterialUnitRepository;

	public RawMaterialUnit addRawMaterialUnit(RawMaterialUnitBo rawMaterialUnitBo) throws InventoryException {
		try {
			return rawMaterialUnitRepository.save(new RawMaterialUnit(rawMaterialUnitBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while saving raw material unit", e, 500);
		}
	}
	
	public List<RawMaterialUnit> getAllRawMaterialUnits() throws InventoryException {
		List<RawMaterialUnit> rawMaterialUnits = new ArrayList<>();
		try {
			rawMaterialUnitRepository.findAll()
				.forEach(rawMaterialUnits::add);
			return rawMaterialUnits;
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting all raw material units", e, 500);
		}
	}

	public RawMaterialUnit getRawMaterialUnit(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given Raw material unit id is invalid", 400) ;
		}
		try {
			return rawMaterialUnitRepository.findOne(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while getting raw material unit with id: " + id, e, 500) ;
		}
	}

	public RawMaterialUnit updateRawMaterialUnit(RawMaterialUnitBo rawMaterialUnitBo) throws InventoryException {
		try {
			return rawMaterialUnitRepository.save(new RawMaterialUnit(rawMaterialUnitBo));
		} catch (Exception e) {
			throw new InventoryException("Exception occured while updaing raw materia unit", e, 500) ;
		}
	}

	public void deleteRawMaterialUnit(String id) throws InventoryException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new InventoryException("Given Raw material unit id is invalid: " + id, 400) ;
		}
		try {
			rawMaterialUnitRepository.delete(id);
		} catch (Exception e) {
			throw new InventoryException("Exception occured while deleting raw material unit", e, 500) ;
		}
	}

}
