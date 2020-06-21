package com.poc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

//@Service
@Component
public class AppService {

  //@Autowired
  //@Resource
  @Inject
  Country country;

  public String getMsg() {
    return country.toString();
  }
}
