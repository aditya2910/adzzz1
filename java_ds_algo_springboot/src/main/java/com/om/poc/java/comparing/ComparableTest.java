package com.om.poc.java.comparing;

import java.util.Collections;
import java.util.List;

public class ComparableTest {

  public static void main(String[] args) {
    List<CompCar> compCars = CarUtil.getCompCars();
    Collections.sort(compCars);
    compCars.forEach(System.out::println);
  }
}
