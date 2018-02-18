// TODO: add inventory in package names after orgname
package com.demo.orgname.controller.brand;

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

import com.demo.orgname.dao.brand.ProductType;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.brand.ProductTypeBo;
import com.demo.orgname.service.brand.ProductTypeServiceImpl;

@RestController
@RequestMapping("/type")
public class ProductTypeController {
	
	@Autowired
	private ProductTypeServiceImpl productTypeService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductTypeDto> save(@RequestBody ProductTypeDto productTypeDto) throws InventoryException {
		ProductTypeBo productTypeBo = getProductTypeBo(productTypeDto);
		ProductType productType = productTypeService.saveType(productTypeBo);
		
		return new ResponseEntity<ProductTypeDto>(new ProductTypeDto(productType), HttpStatus.OK);
    }

	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductTypeDto>> getAll() throws InventoryException {
		List<ProductTypeDto> productTypeDtos = productTypeService.getAllTypes()
													.stream()
													.map(ProductTypeDto::new)
													.collect(Collectors.toList());
		
		return new ResponseEntity<List<ProductTypeDto>>(productTypeDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductTypeDto> getById(@PathVariable String id) throws InventoryException {
		ProductType productType = productTypeService.getType(id);
		if(productType == null) {
			throw new InventoryException("No product type was Found for given id", 404);
		}
		return new ResponseEntity<ProductTypeDto>(new ProductTypeDto(productType), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductTypeDto> update(@RequestBody ProductTypeDto productTypeDto, @PathVariable String id) throws InventoryException {
		productTypeDto.setId(id);
		ProductTypeBo productTypeBo = getProductTypeBo(productTypeDto);
		ProductType productType = productTypeService.updateType(productTypeBo);
		
		return new ResponseEntity<ProductTypeDto>(new ProductTypeDto(productType), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductTypeDto> deleteById(@PathVariable String id) throws InventoryException {
		productTypeService.deleteType(id);
		return new ResponseEntity<ProductTypeDto>(HttpStatus.OK);
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
	
	private ProductTypeBo getProductTypeBo(ProductTypeDto productTypeDto) {
		return new ProductTypeBo(productTypeDto);
	}

}
