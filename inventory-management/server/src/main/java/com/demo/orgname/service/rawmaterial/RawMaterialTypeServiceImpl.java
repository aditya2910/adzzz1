package com.demo.orgname.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.rawmaterial.RawMaterialType;
import com.demo.orgname.dao.rawmaterial.RawMaterialTypeRepository;
import com.demo.orgname.exception.RawMaterialTypeException;
import com.demo.orgname.util.StringUtility;

@Service
public class RawMaterialTypeServiceImpl {
	
	@Autowired
	private RawMaterialTypeRepository rawMaterialTypeRepository;

	public RawMaterialType addRawMaterialType(RawMaterialTypeBo rawMaterialTypeBo) throws RawMaterialTypeException {
		try {
			return rawMaterialTypeRepository.save(new RawMaterialType(rawMaterialTypeBo));
		} catch (Exception e) {
			throw new RawMaterialTypeException("Exception occured while saving raw material type", e, 500);
		}
	}
	
	public List<RawMaterialType> getAllRawMaterialTypes() throws RawMaterialTypeException {
		List<RawMaterialType> rawMaterialTypes = new ArrayList<>();
		try {
			rawMaterialTypeRepository.findAll()
			.forEach(rawMaterialTypes::add);
			return rawMaterialTypes;
		} catch (Exception e) {
			throw new RawMaterialTypeException("Exception occured while getting all raw material types", e, 500);
		}
	}

	public RawMaterialType getRawMaterialType(String id) throws RawMaterialTypeException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new RawMaterialTypeException("Given Raw material is invalid", 400) ;
		}
		try {
			return rawMaterialTypeRepository.findOne(id);
		} catch (Exception e) {
			throw new RawMaterialTypeException("Exception occured while getting raw material type with id: " + id, e, 500) ;
		}
	}

	public RawMaterialType updateRawMaterialType(RawMaterialTypeBo rawMaterialTypeBo) throws RawMaterialTypeException {
		try {
			return rawMaterialTypeRepository.save(new RawMaterialType(rawMaterialTypeBo));
		} catch (Exception e) {
			throw new RawMaterialTypeException("Exception occured while updaing raw material", e, 500) ;
		}
	}

	public void deleteRawMaterialType(String id) throws RawMaterialTypeException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new RawMaterialTypeException("Given Raw material type id is invalid: " + id, 400) ;
		}
		try {
			rawMaterialTypeRepository.delete(id);
		} catch (Exception e) {
			throw new RawMaterialTypeException("Exception occured while deleting raw material type", e, 500) ;
		}
	}

	

}
