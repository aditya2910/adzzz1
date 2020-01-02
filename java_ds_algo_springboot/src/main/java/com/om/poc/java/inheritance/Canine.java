package com.om.poc.java.inheritance;

public abstract class Canine extends Animal {

  public void wagTail() {
    System.out.println("Canine wagtail..");
  }

  @Override
  public void move() {
    System.out.println("Canine....move");
  }
}
