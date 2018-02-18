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

import com.demo.orgname.dao.rawmaterial.RawMaterialType;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.RawMaterialTypeException;
import com.demo.orgname.service.rawmaterial.RawMaterialTypeBo;
import com.demo.orgname.service.rawmaterial.RawMaterialTypeServiceImpl;

@RestController
@RequestMapping("/rawMaterialTypes")
public class RawMaterialTypeController {
	
	@Autowired
	private RawMaterialTypeServiceImpl rawMaterialTypeServiceImpl;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RawMaterialTypeDto> save(@RequestBody RawMaterialTypeDto rawMaterialTypeDto) throws RawMaterialTypeException {
		RawMaterialTypeBo rawMaterialBo = getRawMaterialTypeBo(rawMaterialTypeDto);
		RawMaterialType rawMaterialType = rawMaterialTypeServiceImpl.addRawMaterialType(rawMaterialBo);
		
		return new ResponseEntity<RawMaterialTypeDto>(new RawMaterialTypeDto(rawMaterialType), HttpStatus.OK);
    }

	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<RawMaterialTypeDto>> getAll() throws RawMaterialTypeException {
		List<RawMaterialTypeDto> rawMaterialTypeDtos = rawMaterialTypeServiceImpl.getAllRawMaterialTypes()
				.stream()
				.map(RawMaterialTypeDto::new)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<RawMaterialTypeDto>>(rawMaterialTypeDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RawMaterialTypeDto> getById(@PathVariable String id) throws RawMaterialTypeException {
		RawMaterialType rawMaterialType = rawMaterialTypeServiceImpl.getRawMaterialType(id);
		if(rawMaterialType == null) {
			throw new RawMaterialTypeException("No Raw Material type was Found", 404);
		}
		return new ResponseEntity<RawMaterialTypeDto>(new RawMaterialTypeDto(rawMaterialType), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RawMaterialTypeDto> update(@RequestBody RawMaterialTypeDto rawMaterialTypeDto, @PathVariable String id) throws RawMaterialTypeException {
		rawMaterialTypeDto.setId(id);
		RawMaterialTypeBo rawMaterialTypeBo = getRawMaterialTypeBo(rawMaterialTypeDto);
		RawMaterialType rawMaterialType = rawMaterialTypeServiceImpl.updateRawMaterialType(rawMaterialTypeBo);
		
		return new ResponseEntity<RawMaterialTypeDto>(new RawMaterialTypeDto(rawMaterialType), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RawMaterialTypeDto> deleteById(@PathVariable String id) throws RawMaterialTypeException {
		rawMaterialTypeServiceImpl.deleteRawMaterialType(id);
		return new ResponseEntity<RawMaterialTypeDto>(HttpStatus.OK);
    }
	
	
	@ExceptionHandler(RawMaterialTypeException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		if(ex instanceof RawMaterialTypeException) {
			RawMaterialTypeException rmTypeEx = (RawMaterialTypeException) ex;
			error.setErrorCode(rmTypeEx.getErrorCode());
			error.setMessage(rmTypeEx.getMessage());
			error.setDescription(ex.getLocalizedMessage());
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(rmTypeEx.getErrorCode()));
		}
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setDescription(ex.getCause().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	private RawMaterialTypeBo getRawMaterialTypeBo(RawMaterialTypeDto rawMaterialTypeDto) {
		return new RawMaterialTypeBo(rawMaterialTypeDto);
	}
}
