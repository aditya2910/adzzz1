package com.cb.springdata.sample.service;

import com.cb.springdata.sample.entities.Building;
import com.cb.springdata.sample.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    

    @Override
    public Building save(@Valid Building building) {
        return buildingRepository.save(building);
    }

	@Override
	public List<Building> getAllBuildings() {
		return (List<Building>) buildingRepository.findAll();
	}

}
