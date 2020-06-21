package com.poc.java.comparing;

import java.util.ArrayList;
import java.util.List;

public class CarUtil {

  public static List<CompCar> getCompCars() {
    List<CompCar> compCars = new ArrayList<>();
    CompCar compCar1 = new CompCar(1,"Maruti", "Alto", 2010, 3.1, Type.HACHBACK);
    CompCar compCar2 = new CompCar(4,"Toyota", "LC", 2012, 83.18, Type.SUV);
    CompCar compCar3 = new CompCar(2,"Toyota", "Etios", 2015, 8.5, Type.SEDAN);

    compCars.add(compCar1);
    compCars.add(compCar2);
    compCars.add(compCar3);

    return compCars;
  }

  public static List<Car> getCars() {
    List<Car> cars = new ArrayList<>();
    Car car1 = new Car(1,"Maruti", "Alto", 2010, 3.1, Type.HACHBACK);
    Car car2 = new Car(4,"Toyota", "LC", 2012, 83.18, Type.SUV);
    Car car3 = new Car(2,"Hyundai", "Creta", 2015, 8.5, Type.SEDAN);
    Car car4 = new Car(2,"Kia", "Seltos", 2015, 8.5, Type.SEDAN);


    cars.add(car1);
    cars.add(car2);
    cars.add(car3);
    cars.add(car4);

    return cars;
  }
}
