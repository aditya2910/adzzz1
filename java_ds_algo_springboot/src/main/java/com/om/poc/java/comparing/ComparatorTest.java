package com.om.poc.java.comparing;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

  public static void main(String[] args) {
    List<Car> cars = CarUtil.getCars();

    Comparator<Car> carMakeComparator = (car1, car2) -> {
      if (car1.getMake() == car2.getMake()) {
        return 0;
      }
      if (car1.getMake() == null) {
        return -1;
      }
      if (car2.getMake() == null) {
        return 1;
      }
      return car1.getMake().compareTo(car2.getMake());
    };


    Comparator<Car> carIdComparator = (car1, car2) -> {
      return car1.getId() < car2.getId() ? -1 : 1;
    };

    Collections.sort(cars, carMakeComparator);
    cars.forEach(System.out::println);

    Collections.sort(cars, carIdComparator);
    cars.forEach(System.out::println);
  }
}
