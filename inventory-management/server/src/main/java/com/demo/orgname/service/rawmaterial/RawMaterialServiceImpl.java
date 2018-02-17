package com.demo.orgname.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.rawmaterial.RawMaterial;
import com.demo.orgname.dao.rawmaterial.RawMaterialRepository;
import com.demo.orgname.exception.RawMaterialException;

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

	public RawMaterial addRawMaterial(RawMaterialBo bo) throws RawMaterialException {
		RawMaterial rm = null;
		try {
			rm = new RawMaterial(bo);
			rm = repository.save(rm);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RawMaterialException("Exception occured while saving raw material.", e);
		}
		return rm;
	}
	
	public RawMaterial getRawMaterial(String id) {
		return repository.findOne(id);
	}

	public int getRawMaterialsCount() {
		return (int) repository.count();
	}

	public RawMaterial updateRawMaterial(RawMaterial rawMaterial) {
		//return repository.save(rawMaterial);
		return null;
	}
}
