package com.cb.springdata.sample.service;

import com.cb.springdata.sample.entities.Building;

import javax.validation.Valid;
import java.util.List;

public interface BuildingService {

    Building save(@Valid Building building);

	List<Building> getAllBuildings();

}
