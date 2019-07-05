package com.cb.springdata.sample.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.springdata.sample.entities.Building;
import com.cb.springdata.sample.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;
	
	@PostMapping
	public Building saveBuilding(@Valid @RequestBody BuildingDto dto) {
		Building building = getBuilding(dto);
		return buildingService.save(building);
	}
	
	@GetMapping
	public List<Building> getBuilding() {
		return buildingService.getAllBuildings();
	}

	private Building getBuilding(BuildingDto dto) {
		Building building = new Building();
		building.setId(dto.getId());
		building.setCompanyId(dto.getCompanyId());
		building.setName(dto.getName());
		
		return building;
	}

}
