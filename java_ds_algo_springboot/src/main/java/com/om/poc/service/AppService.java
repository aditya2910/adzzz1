package com.om.poc.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
