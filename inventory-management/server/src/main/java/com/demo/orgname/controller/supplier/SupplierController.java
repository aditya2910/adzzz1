package com.demo.orgname.controller.supplier;

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

import com.demo.orgname.dao.supplier.Supplier;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.supplier.SupplierBo;
import com.demo.orgname.service.supplier.SupplierServiceImpl;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierServiceImpl supplierService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SupplierDto> save(@RequestBody SupplierDto supplierDto) throws InventoryException {
		SupplierBo supplierBo = getSupplierBo(supplierDto);
		Supplier supplier = supplierService.saveSupplier(supplierBo);
		
		return new ResponseEntity<SupplierDto>(new SupplierDto(supplier), HttpStatus.OK);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SupplierDto>> getAll() throws InventoryException {
		List<SupplierDto> supplierDtos = supplierService.getAllSuppliers()
				.stream()
				.map(SupplierDto::new)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<SupplierDto>>(supplierDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SupplierDto> getById(@PathVariable String id) throws InventoryException {
		Supplier supplier = supplierService.getSupplier(id);
		if(supplier == null) {
			throw new InventoryException("No supplier was Found for given id", 404);
		}
		return new ResponseEntity<SupplierDto>(new SupplierDto(supplier), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SupplierDto> update(@RequestBody SupplierDto supplierDto, @PathVariable String id) throws InventoryException {
		supplierDto.setId(id);
		SupplierBo supplierBo = getSupplierBo(supplierDto);
		Supplier supplier = supplierService.updateSupplier(supplierBo);
		
		return new ResponseEntity<SupplierDto>(new SupplierDto(supplier), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<SupplierDto> deleteById(@PathVariable String id) throws InventoryException {
		supplierService.deleteSupplier(id);
		return new ResponseEntity<SupplierDto>(HttpStatus.OK);
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
	
	private SupplierBo getSupplierBo(SupplierDto supplierDto) {
		return new SupplierBo(supplierDto);
	}

}
