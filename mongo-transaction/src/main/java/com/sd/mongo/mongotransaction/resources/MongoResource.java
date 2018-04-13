package com.sd.mongo.mongotransaction.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongoTransaction")
public class MongoResource {

  @RequestMapping(method= RequestMethod.GET)
  public String startWork() {
    System.out.println("Hello.....");
    return "hello";
  }

}
