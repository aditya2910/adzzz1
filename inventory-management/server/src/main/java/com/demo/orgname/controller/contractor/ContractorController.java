package com.demo.orgname.controller.contractor;

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

import com.demo.orgname.dao.contractor.Contractor;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.contractor.ContractorBo;
import com.demo.orgname.service.contractor.ContractorServiceImpl;

@RestController
@RequestMapping("/contractor")
public class ContractorController {
	
	@Autowired
	private ContractorServiceImpl contractorService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ContractorDto> save(@RequestBody ContractorDto contractorDto) throws InventoryException {
		ContractorBo contractorBo = getContractorBo(contractorDto);
		Contractor contractor = contractorService.saveContractor(contractorBo);
		
		return new ResponseEntity<ContractorDto>(new ContractorDto(contractor), HttpStatus.OK);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ContractorDto>> getAll() throws InventoryException {
		List<ContractorDto> contractorDtos = contractorService.getAllContractors()
													.stream()
													.map(ContractorDto::new)
													.collect(Collectors.toList());
		
		return new ResponseEntity<List<ContractorDto>>(contractorDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ContractorDto> getById(@PathVariable String id) throws InventoryException {
		Contractor contractor = contractorService.getContractor(id);
		if(contractor == null) {
			throw new InventoryException("No contractor was Found for given id", 404);
		}
		return new ResponseEntity<ContractorDto>(new ContractorDto(contractor), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ContractorDto> update(@RequestBody ContractorDto contractorDto, @PathVariable String id) throws InventoryException {
		contractorDto.setId(id);
		ContractorBo contractorBo = getContractorBo(contractorDto);
		Contractor contractor = contractorService.updateContractor(contractorBo);
		
		return new ResponseEntity<ContractorDto>(new ContractorDto(contractor), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ContractorDto> deleteById(@PathVariable String id) throws InventoryException {
		contractorService.deleteContractor(id);
		return new ResponseEntity<ContractorDto>(HttpStatus.OK);
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

	private ContractorBo getContractorBo(ContractorDto contractorDto) {
		return new ContractorBo(contractorDto);
	}
}
