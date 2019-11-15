package com.om.poc.java.equalshashcode;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

  public static void main(String[] args) {
    Map<Customer, String> map = new HashMap<>();

    Customer c1 = new Customer(1, "john");
    Customer c2 = new Customer(2, "helen");
    Customer c3 = new Customer(3, "katy");
    Customer c4 = new Customer(1, "john");

    map.put(c1, "CS");
    map.put(c2, "EC");
    map.put(c3, "IT");
    map.put(c4, "CS");

    System.out.println(map);
  }
}
