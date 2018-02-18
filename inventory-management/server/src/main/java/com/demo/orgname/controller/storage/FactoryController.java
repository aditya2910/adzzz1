package com.demo.orgname.controller.storage;

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

import com.demo.orgname.dao.storage.Factory;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.storage.FactoryBo;
import com.demo.orgname.service.storage.FactoryServiceImpl;

@RestController
@RequestMapping("/factory")
public class FactoryController {
	
	@Autowired
	private FactoryServiceImpl factoryService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FactoryDto> save(@RequestBody FactoryDto factoryDto) throws InventoryException {
		FactoryBo factoryBo = getFactoryBo(factoryDto);
		Factory factory = factoryService.addFactory(factoryBo);
		
		return new ResponseEntity<FactoryDto>(new FactoryDto(factory), HttpStatus.OK);
    }

	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<FactoryDto>> getAll() throws InventoryException {
		List<FactoryDto> factoryDtos = factoryService.getAllFactories()
													.stream()
													.map(FactoryDto::new)
													.collect(Collectors.toList());
		
		return new ResponseEntity<List<FactoryDto>>(factoryDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FactoryDto> getById(@PathVariable String id) throws InventoryException {
		Factory factory = factoryService.getFactory(id);
		if(factory == null) {
			throw new InventoryException("No Factory was Found for given id", 404);
		}
		return new ResponseEntity<FactoryDto>(new FactoryDto(factory), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FactoryDto> update(@RequestBody FactoryDto factoryDto, @PathVariable String id) throws InventoryException {
		factoryDto.setId(id);
		FactoryBo factoryBo = getFactoryBo(factoryDto);
		Factory factory = factoryService.updateFactory(factoryBo);
		
		return new ResponseEntity<FactoryDto>(new FactoryDto(factory), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<FactoryDto> deleteById(@PathVariable String id) throws InventoryException {
		factoryService.deleteFactory(id);
		return new ResponseEntity<FactoryDto>(HttpStatus.OK);
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

	private FactoryBo getFactoryBo(FactoryDto factoryDto) {
		return new FactoryBo(factoryDto);
	}
}
