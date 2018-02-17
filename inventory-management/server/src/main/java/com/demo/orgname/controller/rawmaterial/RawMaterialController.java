package com.demo.orgname.controller.rawmaterial;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.rawmaterial.RawMaterial;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.RawMaterialException;
import com.demo.orgname.service.rawmaterial.RawMaterialBo;
import com.demo.orgname.service.rawmaterial.RawMaterialServiceImpl;

@RestController
@RequestMapping("/rawMaterial")
public class RawMaterialController {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private RawMaterialServiceImpl rawMaterialService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RawMaterialDto> save(@RequestBody RawMaterialDto rawMaterialDto) throws RawMaterialException {
		System.out.println("Saving Raw Material : " + rawMaterialDto.getName());
		RawMaterialBo rmBo = getRawMaterialBo(rawMaterialDto);
		RawMaterial rm = rawMaterialService.addRawMaterial(rmBo);
		
		return new ResponseEntity<RawMaterialDto>(RawMaterialDtoConverter.convert(rm), HttpStatus.OK);
    }

	private RawMaterialBo getRawMaterialBo(RawMaterialDto rawMaterialDto) throws RawMaterialException {
		try {
			return new RawMaterialBo(rawMaterialDto);
		} catch (Exception e) {
			throw new RawMaterialException("Input Raw Material is having invalid value.", e, 400);
		}
	}
	
	@ExceptionHandler(RawMaterialException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		if(ex instanceof RawMaterialException) {
			RawMaterialException rmEx = (RawMaterialException) ex;
			error.setErrorCode(rmEx.getErrorCode());
			error.setMessage(rmEx.getMessage());
			error.setDescription(ex.getLocalizedMessage());
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(rmEx.getErrorCode()));
		}
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setDescription(ex.getCause().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RawMaterialDto> getAll() {
		System.out.println("..........................................getting all raw materials: " + context);
		return rawMaterialService.getAllRawMaterials().stream()
			.map(RawMaterialDtoConverter::convert)
			.collect(Collectors.toList());
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RawMaterial getById(@PathVariable String id) throws RawMaterialException {
		System.out.println("getting raw material");
		RawMaterial rawMaterial = rawMaterialService.getRawMaterial(id);
		System.out.println("rawMaterial: " + rawMaterial);
		if(rawMaterial == null) {
			throw new RawMaterialException("No Raw Material Found", 404);
		}
        return rawMaterial;
    }
	
	@RequestMapping(value="/count", method= RequestMethod.GET)
    public int getCount() {
		System.out.println("getting raw materials count");
		return rawMaterialService.getRawMaterialsCount();
    }
	
	@RequestMapping(method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RawMaterialDto update(@RequestBody RawMaterial rawMaterial) {
		System.out.println("updating raw material");
		RawMaterial rm = rawMaterialService.updateRawMaterial(rawMaterial);
		return RawMaterialDtoConverter.convert(rm);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RawMaterialDto> deleteById(@PathVariable String id) throws RawMaterialException {
		System.out.println("delete raw material");
		rawMaterialService.deleteRawMaterial(id);
		return new ResponseEntity<RawMaterialDto>(HttpStatus.OK);
    }
	// custom query - NOT WORKING
}
