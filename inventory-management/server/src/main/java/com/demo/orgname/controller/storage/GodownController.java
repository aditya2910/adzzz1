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

import com.demo.orgname.dao.storage.Godown;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.storage.GodownBo;
import com.demo.orgname.service.storage.GodownServiceImpl;

@RestController
@RequestMapping("/godown")
public class GodownController {
	
	@Autowired
	private GodownServiceImpl godownService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GodownDto> save(@RequestBody GodownDto godownDto) throws InventoryException {
		GodownBo godownBo = getGodownBo(godownDto);
		Godown godown = godownService.addGodown(godownBo);
		
		return new ResponseEntity<GodownDto>(new GodownDto(godown), HttpStatus.OK);
    }

	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<GodownDto>> getAll() throws InventoryException {
		List<GodownDto> godownDtos = godownService.getAllGodowns()
													.stream()
													.map(GodownDto::new)
													.collect(Collectors.toList());
		
		return new ResponseEntity<List<GodownDto>>(godownDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GodownDto> getById(@PathVariable String id) throws InventoryException {
		Godown godown = godownService.getGodown(id);
		if(godown == null) {
			throw new InventoryException("No godown was Found for given id", 404);
		}
		return new ResponseEntity<GodownDto>(new GodownDto(godown), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GodownDto> update(@RequestBody GodownDto godownDto, @PathVariable String id) throws InventoryException {
		godownDto.setId(id);
		GodownBo godownBo = getGodownBo(godownDto);
		Godown godown = godownService.updateGodown(godownBo);
		
		return new ResponseEntity<GodownDto>(new GodownDto(godown), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<GodownDto> deleteById(@PathVariable String id) throws InventoryException {
		godownService.deleteGodown(id);
		return new ResponseEntity<GodownDto>(HttpStatus.OK);
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
	
	private GodownBo getGodownBo(GodownDto godownDto) {
		return new GodownBo(godownDto);
	}

}
