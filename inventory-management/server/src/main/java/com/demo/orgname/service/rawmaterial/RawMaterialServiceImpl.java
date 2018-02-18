package com.demo.orgname.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.rawmaterial.RawMaterial;
import com.demo.orgname.dao.rawmaterial.RawMaterialRepository;
import com.demo.orgname.exception.RawMaterialException;
import com.demo.orgname.util.StringUtility;

@Service
public class RawMaterialServiceImpl {
	
	@Autowired
	private RawMaterialRepository repository;
	
	public List<RawMaterial> getAllRawMaterials() throws RawMaterialException {
		List<RawMaterial> rawMaterials = new ArrayList<>();
		try {
			repository.findAll()
				.forEach(rawMaterials::add);
			return rawMaterials;
		} catch (Exception e) {
			throw new RawMaterialException("Exception occured while getting all raw material.", e, 500);
		}
	}

	public RawMaterial addRawMaterial(RawMaterialBo bo) throws RawMaterialException {
		try {
			return repository.save(new RawMaterial(bo));
		} catch (Exception e) {
			throw new RawMaterialException("Exception occured while saving raw material.", e, 500);
		}
	}
	
	public RawMaterial getRawMaterial(String id) throws RawMaterialException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new RawMaterialException("Given Raw material is invalid", 400) ;
		}
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new RawMaterialException("Exception occured while getting raw material with id: " + id, e, 500) ;
		}
	}

	public int getRawMaterialsCount() throws RawMaterialException {
		try {
			return (int) repository.count();
		} catch (Exception e) {
			throw new RawMaterialException("Exception occured while getting count of raw materials", e, 500) ;
		}
	}

	public RawMaterial updateRawMaterial(RawMaterialBo bo) throws RawMaterialException {
		try {
			return repository.save(new RawMaterial(bo));
		} catch (Exception e) {
			throw new RawMaterialException("Exception occured while updaing raw material", e, 500) ;
		}
	}

	public void deleteRawMaterial(String id) throws RawMaterialException {
		if(!StringUtility.checkIfStringIsNotNullOrEmpty(id)) {
			throw new RawMaterialException("Given Raw material is invalid", 400) ;
		}
		try {
			repository.delete(id);
		} catch (NullPointerException e) {
			throw new RawMaterialException("Exception occured while deleting raw material", e, 500) ;
		} catch (Exception e) {
			throw new RawMaterialException("Exception occured while deleting raw material", e, 500) ;
		}
	}
}
