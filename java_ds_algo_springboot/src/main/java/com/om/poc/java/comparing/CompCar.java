package com.om.poc.java.comparing;

public class CompCar implements Comparable<CompCar> {

  private int id;
  private String make;
  private String model;
  private int year;
  private double price;
  private Type type;

  public CompCar(final int id,
                 final String make,
                 final String model,
                 final int year,
                 final double price,
                 final Type type) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(final String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(final String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(final int year) {
    this.year = year;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(final double price) {
    this.price = price;
  }

  public Type getType() {
    return type;
  }

  public void setType(final Type type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Car{" + "id=" + id + ", make='" + make + '\'' + ", model='" + model + '\'' + ", year=" + year + ", price="
        + price + ", type=" + type + '}';
  }

  @Override
  public int compareTo(final CompCar car) {
    return this.id - car.id;
  }
}
