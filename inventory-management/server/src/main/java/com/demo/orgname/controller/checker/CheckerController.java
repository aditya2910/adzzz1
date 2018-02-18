package com.demo.orgname.controller.checker;

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

import com.demo.orgname.dao.checker.Checker;
import com.demo.orgname.exception.ErrorResponse;
import com.demo.orgname.exception.InventoryException;
import com.demo.orgname.service.checker.CheckerBo;
import com.demo.orgname.service.checker.CheckerServiceImpl;

@RestController
@RequestMapping("/checker")
public class CheckerController {
	
	@Autowired
	private CheckerServiceImpl checkerService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CheckerDto> save(@RequestBody CheckerDto checkerDto) throws InventoryException {
		CheckerBo checkerBo = getCheckerBo(checkerDto);
		Checker checker = checkerService.saveChecker(checkerBo);
		
		return new ResponseEntity<CheckerDto>(new CheckerDto(checker), HttpStatus.OK);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CheckerDto>> getAll() throws InventoryException {
		List<CheckerDto> checkerDtos = checkerService.getAllCheckers()
													.stream()
													.map(CheckerDto::new)
													.collect(Collectors.toList());
		
		return new ResponseEntity<List<CheckerDto>>(checkerDtos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CheckerDto> getById(@PathVariable String id) throws InventoryException {
		Checker checker = checkerService.getChecker(id);
		if(checker == null) {
			throw new InventoryException("No checker was Found for given id", 404);
		}
		return new ResponseEntity<CheckerDto>(new CheckerDto(checker), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CheckerDto> update(@RequestBody CheckerDto checkerDto, @PathVariable String id) throws InventoryException {
		checkerDto.setId(id);
		CheckerBo checkerBo = getCheckerBo(checkerDto);
		Checker checker = checkerService.updateChecker(checkerBo);
		
		return new ResponseEntity<CheckerDto>(new CheckerDto(checker), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CheckerDto> deleteById(@PathVariable String id) throws InventoryException {
		checkerService.deleteChecker(id);
		return new ResponseEntity<CheckerDto>(HttpStatus.OK);
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
	
	private CheckerBo getCheckerBo(CheckerDto checkerDto) {
		return new CheckerBo(checkerDto);
	}

}
