package com.demo.orgname.controller.rawmaterial;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.rawmaterial.RawMaterialUnit;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.rawmaterial.RawMaterialUnitBo;
import com.demo.orgname.service.rawmaterial.RawMaterialUnitServiceImpl;

@RestController
@RequestMapping("/rawMaterialUnit")
public class RawMaterialUnitsController {
	
	@Autowired
	private RawMaterialUnitServiceImpl rawMaterialUnitServiceImpl;

	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RawMaterialUnitDto> save(@RequestBody RawMaterialUnitDto rawMaterialUnitDto) throws InventoryException {
		RawMaterialUnitBo rawMaterialUnitBo = getRawMaterialUnitBo(rawMaterialUnitDto);
		RawMaterialUnit rawMaterialUnit = rawMaterialUnitServiceImpl.addRawMaterialUnit(rawMaterialUnitBo);
		
		return new ResponseEntity<RawMaterialUnitDto>(new RawMaterialUnitDto(rawMaterialUnit), HttpStatus.OK);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<RawMaterialUnitDto>> getAll() throws InventoryException {
		List<RawMaterialUnitDto> rawMaterialUnitDtos = rawMaterialUnitServiceImpl.getAllRawMaterialUnits()
				.stream()
				.map(RawMaterialUnitDto::new)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<RawMaterialUnitDto>>(rawMaterialUnitDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RawMaterialUnitDto> getById(@PathVariable String id) throws InventoryException {
		RawMaterialUnit rawMaterialUnit = rawMaterialUnitServiceImpl.getRawMaterialUnit(id);
		if(rawMaterialUnit == null) {
			throw new InventoryException("No Raw Material unit was Found", 404);
		}
		return new ResponseEntity<RawMaterialUnitDto>(new RawMaterialUnitDto(rawMaterialUnit), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RawMaterialUnitDto> update(@RequestBody RawMaterialUnitDto rawMaterialUnitDto, @PathVariable String id) throws InventoryException {
		rawMaterialUnitDto.setId(id);
		RawMaterialUnitBo rawMaterialUnitBo = getRawMaterialUnitBo(rawMaterialUnitDto);
		RawMaterialUnit rawMaterialUnit = rawMaterialUnitServiceImpl.updateRawMaterialUnit(rawMaterialUnitBo);
		
		return new ResponseEntity<RawMaterialUnitDto>(new RawMaterialUnitDto(rawMaterialUnit), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RawMaterialUnitDto> deleteById(@PathVariable String id) throws InventoryException {
		rawMaterialUnitServiceImpl.deleteRawMaterialUnit(id);
		return new ResponseEntity<RawMaterialUnitDto>(HttpStatus.OK);
    }

	
	@ExceptionHandler(InventoryException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		if(ex instanceof InventoryException) {
			InventoryException inventoryExcption = (InventoryException) ex;
			error.setErrorCode(inventoryExcption.getErrorCode());
			error.setMessage(inventoryExcption.getMessage());
			error.setDescription(ex.getLocalizedMessage());
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(inventoryExcption.getErrorCode()));
		}
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setDescription(ex.getCause().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private RawMaterialUnitBo getRawMaterialUnitBo(RawMaterialUnitDto rawMaterialUnitDto) {
		return new RawMaterialUnitBo(rawMaterialUnitDto);
	}
}
