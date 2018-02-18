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

import com.demo.orgname.dao.brand.ProductBrand;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.brand.ProductBrandBo;
import com.demo.orgname.service.brand.ProductBrandServiceImpl;

@RestController
@RequestMapping("/brand")
public class ProductBrandController {
	
	@Autowired
	private ProductBrandServiceImpl brandService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductBrandDto> save(@RequestBody ProductBrandDto productBrandDto) throws InventoryException {
		ProductBrandBo productBrandBo = getFactoryBo(productBrandDto);
		ProductBrand productBrand = brandService.saveBrand(productBrandBo);
		
		return new ResponseEntity<ProductBrandDto>(new ProductBrandDto(productBrand), HttpStatus.OK);
    }

	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductBrandDto>> getAll() throws InventoryException {
		List<ProductBrandDto> productBrandDtos = brandService.getAllBrands()
													.stream()
													.map(ProductBrandDto::new)
													.collect(Collectors.toList());
		
		return new ResponseEntity<List<ProductBrandDto>>(productBrandDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductBrandDto> getById(@PathVariable String id) throws InventoryException {
		ProductBrand productBrand = brandService.getBrand(id);
		if(productBrand == null) {
			throw new InventoryException("No product brand was Found for given id", 404);
		}
		return new ResponseEntity<ProductBrandDto>(new ProductBrandDto(productBrand), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductBrandDto> update(@RequestBody ProductBrandDto productBrandDto, @PathVariable String id) throws InventoryException {
		productBrandDto.setId(id);
		ProductBrandBo productBrandBo = getFactoryBo(productBrandDto);
		ProductBrand productBrand = brandService.updateBrand(productBrandBo);
		
		return new ResponseEntity<ProductBrandDto>(new ProductBrandDto(productBrand), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductBrandDto> deleteById(@PathVariable String id) throws InventoryException {
		brandService.deleteBrand(id);
		return new ResponseEntity<ProductBrandDto>(HttpStatus.OK);
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
	
	private ProductBrandBo getFactoryBo(ProductBrandDto productBrandDto) {
		return new ProductBrandBo(productBrandDto);
	}

}
