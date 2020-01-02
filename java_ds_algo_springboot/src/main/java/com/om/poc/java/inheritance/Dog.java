package com.om.poc.java.inheritance;

public class Dog extends Canine{
  @Override
  public void makeNoise() {
    System.out.println("dog make noise...");
  }

  // check removing below move method
  @Override
  public void move() {
    System.out.println("dog....move");
  }

  public void fetch() {
    System.out.println("dog fetch..");
  }

}
