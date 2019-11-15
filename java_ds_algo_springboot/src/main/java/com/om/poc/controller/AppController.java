package com.om.poc.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.om.poc.dto.PersonDto;
import com.om.poc.service.AppService;

@RestController
@RequestMapping("start")
public class AppController {

  @Autowired
  private AppService appService;

  @GetMapping
  public ResponseEntity<String> sayHello() {
    String response = appService.getMsg();
    response = appService.toString() + "--" + response;
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<PersonDto> savePerson(@RequestBody(required = true) String dto,
                                              @RequestParam(defaultValue = "false", required = false) boolean isDomainConversionNeeded) {
//    System.out.println(dto);
//    System.out.println(isDomainConversionNeeded);
//    boolean username = StringUtils.isEmpty(isDomainConversionNeeded) ? isDomainConversionNeeded : false;


    try {
      PersonDto personDto = new ObjectMapper().readValue(dto, PersonDto.class);
      System.out.println(personDto);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new ResponseEntity<>(new PersonDto(), HttpStatus.OK);
  }


}
